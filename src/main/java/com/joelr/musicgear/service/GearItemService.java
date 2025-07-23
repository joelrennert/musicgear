package com.joelr.musicgear.service;

import com.joelr.musicgear.dao.GearItemDao;
import com.joelr.musicgear.model.GearItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GearItemService {

    private final GearItemDao gearItemDao;


    @Autowired
    public GearItemService(GearItemDao gearItemDao) {
        this.gearItemDao = gearItemDao;
    }

    // Get gear items by name or type
    public List<GearItem> getGearItemsByNameOrType(String name, String type) {
        boolean hasName = name != null && !name.isBlank();
        boolean hasType = type != null && !type.isBlank();

        if (hasName && hasType) {
            return gearItemDao.getGearItemsByNameAndType("%" + name + "%", "%" + type + "%");
        } else if (hasType) {
            return gearItemDao.getGearItemsByType("%" + type + "%");
        } else if (hasName) {
            return gearItemDao.getGearItemsByName("%" + name + "%");
        }

        return gearItemDao.getGearItems();
    }

    public GearItem getGearItemById(int id) {
        return gearItemDao.getGearItemById(id);
    }

    public GearItem addGearItem(GearItem gearItem) {
        return gearItemDao.addGearItem(gearItem);
    }

    public GearItem updateGearItem(int id, GearItem updatedGearItem) {
        updatedGearItem.setGearId(id);
        return gearItemDao.updateGearItem(updatedGearItem);
    }

    public void removeGearItem(int id) {
        gearItemDao.removeGearItem(id);
    }
}
