package com.joelr.musicgear.dao;

import com.joelr.musicgear.exception.DaoException;
import com.joelr.musicgear.model.GearItem;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcGearItemDao implements GearItemDao {

    private static final String GEAR_SELECT = "SELECT gear_id, type, name, description, is_vintage ";
    private final JdbcTemplate jdbcTemplate;

    public JdbcGearItemDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<GearItem> getGearItemsByNameAndType(String name, String type) {
        List<GearItem> gearItems = new ArrayList<>();
        String nameParam = "%" + (name == null ? "" : name.trim()) + "%";
        boolean hasType = type != null && !type.trim().isEmpty();
        String sql = GEAR_SELECT + "FROM gear WHERE name ILIKE ?"
                + (hasType ? " AND type ILIKE ?" : "");

        try {
            SqlRowSet results = hasType
                    ? jdbcTemplate.queryForRowSet(sql, nameParam, "%" + type.trim() + "%")
                    : jdbcTemplate.queryForRowSet(sql, nameParam);

            while (results.next()) {
                gearItems.add(mapRowToGearItem(results));
            }
        } catch (CannotGetJdbcConnectionException | DataIntegrityViolationException e) {
            throw new DaoException("Database access error", e);
        }
        return gearItems;
    }

    @Override
    public List<GearItem> getGearItems() {
        List<GearItem> gearItems = new ArrayList<>();
        String sql = GEAR_SELECT + "FROM gear";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                gearItems.add(mapRowToGearItem(results));
            }
        } catch (CannotGetJdbcConnectionException | DataIntegrityViolationException e) {
            throw new DaoException("Database access error", e);
        }
        return gearItems;
    }

    @Override
    public GearItem getGearItemById(int gearId) {
        String sql = GEAR_SELECT + "FROM gear WHERE gear_id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, gearId);
            if (results.next()) {
                return mapRowToGearItem(results);
            }
            return null;
        } catch (CannotGetJdbcConnectionException | DataIntegrityViolationException e) {
            throw new DaoException("Database access error", e);
        }
    }

    @Override
    public List<GearItem> getGearItemsByName(String name) {
        return queryGearItemsBySingleParam("name", name);
    }

    @Override
    public List<GearItem> getGearItemsByType(String type) {
        return queryGearItemsBySingleParam("type", type);
    }

    private List<GearItem> queryGearItemsBySingleParam(String column, String value) {
        List<GearItem> gearItems = new ArrayList<>();
        if (value == null || value.trim().isEmpty()) {
            return gearItems;
        }
        String sql = GEAR_SELECT + "FROM gear WHERE " + column + " ILIKE ?";
        String param = "%" + value.trim() + "%";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, param);
            while (results.next()) {
                gearItems.add(mapRowToGearItem(results));
            }
        } catch (CannotGetJdbcConnectionException | DataIntegrityViolationException e) {
            throw new DaoException("Database access error", e);
        }
        return gearItems;
    }

    @Override
    public GearItem addGearItem(GearItem gearItem) {
        String sql = "INSERT INTO gear (type, name, description, is_vintage) VALUES (?, ?, ?, ?) RETURNING gear_id";
        try {
            Integer id = jdbcTemplate.queryForObject(sql, Integer.class,
                    gearItem.getType(),
                    gearItem.getName(),
                    gearItem.getDescription(),
                    gearItem.getVintage());
            return getGearItemById(id);
        } catch (CannotGetJdbcConnectionException | DataIntegrityViolationException e) {
            throw new DaoException("Database access error", e);
        }
    }

    @Override
    public GearItem updateGearItem(GearItem gearItem) {
        String sql = "UPDATE gear SET name = ?, type = ?, description = ?, is_vintage = ? WHERE gear_id = ?";
        try {
            jdbcTemplate.update(sql,
                    gearItem.getName(),
                    gearItem.getType(),
                    gearItem.getDescription(),
                    gearItem.getVintage(),
                    gearItem.getGearId());
            return gearItem;
        } catch (CannotGetJdbcConnectionException | DataIntegrityViolationException e) {
            throw new DaoException("Database access error", e);
        }
    }

    @Override
    public void removeGearItem(int id) {
        String sql = "DELETE FROM gear WHERE gear_id = ?";
        try {
            jdbcTemplate.update(sql, id);
        } catch (CannotGetJdbcConnectionException | DataIntegrityViolationException e) {
            throw new DaoException("Database access error", e);
        }
    }

    private GearItem mapRowToGearItem(SqlRowSet results) {
        GearItem gearItem = new GearItem();
        gearItem.setGearId(results.getInt("gear_id"));
        gearItem.setType(results.getString("type"));
        gearItem.setName(results.getString("name"));
        gearItem.setDescription(results.getString("description"));
        gearItem.setVintage(results.getBoolean("is_vintage"));
        return gearItem;
    }
}