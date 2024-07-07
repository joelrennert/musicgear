package com.joelr.MusicGear.dao;
import com.joelr.MusicGear.exception.DaoException;
import com.joelr.MusicGear.model.GearItem;

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

    private final String GEAR_SELECT = "SELECT gear_id, type, name, description, is_vintage ";
    private final JdbcTemplate jdbcTemplate;

    public JdbcGearItemDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    // Get a list of gear items by name or type
    @Override
    public List<GearItem> getGearItemsByNameAndType(String name, String type) {
        List<GearItem> products = new ArrayList<>();
        boolean useWildcard = true;

        if (useWildcard) {
            name = "%" + (name == null ? "" : name) + "%";
        }
        boolean checkType = type != null && type.trim().length() > 0;

        String sql = GEAR_SELECT + "FROM gear WHERE name ILIKE ? " +
                (checkType ? " AND type ILIKE ?" : "");
        try {
            SqlRowSet results;
            if (checkType) {
                results = jdbcTemplate.queryForRowSet(sql, name, type);
            } else {
                results = jdbcTemplate.queryForRowSet(sql, name);
            }
            while (results.next()) {
                GearItem gearItem = mapRowToGearItem(results);
                products.add(gearItem);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return products;
    }

    // Get a list of all gear items
    @Override
    public List<GearItem> getGearItems() {
        List<GearItem> gearItems = new ArrayList<>();
        String sql = GEAR_SELECT + "FROM gear ";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                GearItem gearItem = mapRowToGearItem(results);
                gearItems.add(gearItem);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return gearItems;
    }

    // Get a single gear item by id
    @Override
    public GearItem getGearItemById(int gearId) {
        GearItem gearItem = null;
        String sql = GEAR_SELECT + "FROM gear WHERE gear_id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, gearId);
            if (results.next()) {
                gearItem = mapRowToGearItem(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return gearItem;
    }

    // Get a list of gear items by name
    @Override
    public List<GearItem> getGearItemsByName(String name) {
        List<GearItem> gearItems = new ArrayList<>();
        String sql = GEAR_SELECT + "FROM gear WHERE name ILIKE ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, name);
            while (results.next()) {
                gearItems.add(mapRowToGearItem(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return gearItems;
    }

    // Get a list of gear items by type
    @Override
    public List<GearItem> getGearItemsByType(String type) {
        List<GearItem> gearItems = new ArrayList<>();
        String sql = GEAR_SELECT + " FROM gear WHERE type ILIKE ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, type);
            while (results.next()) {
                gearItems.add(mapRowToGearItem(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return gearItems;
    }

    // Add a new gear item
    @Override
    public GearItem addGearItem(GearItem gearItem) {
        GearItem createdGearItem = null;
        String sql = "INSERT INTO gear (type, name, description, is_vintage) " +
                "VALUES (?, ?, ?, ?) RETURNING gear_id";
        try {
            Integer id = jdbcTemplate.queryForObject(sql, int.class,
                                                gearItem.getType(),
                                                gearItem.getName(),
                                                gearItem.getDescription(),
                                                gearItem.getVintage());
            createdGearItem = getGearItemById(id);
        } catch (CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e){
            throw new DaoException("Data integrity violation", e);
        }
        return createdGearItem;
    }

    // Update gear item
    @Override
    public GearItem updateGearItem(GearItem gearItem) {
        String sql = "UPDATE gear SET gear_id = ?, name = ?, type = ?, description = ?, is_vintage = ? WHERE gear_id = ?";
        try {
            jdbcTemplate.update(sql, gearItem.getGearId(), gearItem.getName(), gearItem.getType(), gearItem.getDescription(), gearItem.getVintage(), gearItem.getGearId());
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return gearItem;
    }

    // Update gear item type
//    @Override
//    public GearItem updateGearItemType(GearItem gearItem, String type) {
//        String sql = "UPDATE gear SET type = ? WHERE gear_id = ?";
//        try {
//            jdbcTemplate.update(sql, type, gearItem.getGearId());
//        } catch (CannotGetJdbcConnectionException e){
//            throw new DaoException("Unable to connect to server or database", e);
//        } catch (DataIntegrityViolationException e) {
//            throw new DaoException("Data integrity violation", e);
//        }
//        return gearItem;
//    }

    // Update gear item description
//    @Override
//    public GearItem updateGearItemDescription(GearItem gearItem, String description) {
//        String sql = "UPDATE gear SET description = ? WHERE gear_id = ?";
//        try {
//            jdbcTemplate.update(sql, description, gearItem.getGearId());
//        } catch (CannotGetJdbcConnectionException e){
//            throw new DaoException("Unable to connect to server or database", e);
//        } catch (DataIntegrityViolationException e) {
//            throw new DaoException("Data integrity violation", e);
//        }
//        return gearItem;
//    }

    // Remove gear item
    @Override
    public void removeGearItem(int id) {
        String sql = "DELETE FROM gear WHERE gear_id = ?";
        try {
            jdbcTemplate.update(sql, id);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
    }

    private GearItem mapRowToGearItem(SqlRowSet results){
        GearItem gearItem = new GearItem();
        gearItem.setGearId(results.getInt("gear_id"));
        gearItem.setType(results.getString("type"));
        gearItem.setName(results.getString("name"));
        gearItem.setDescription(results.getString("description"));
        gearItem.setVintage(results.getBoolean("is_vintage"));
        return gearItem;
    }

}
