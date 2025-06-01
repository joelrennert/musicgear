package com.joelr.MusicGear.service;

import com.joelr.MusicGear.dao.GearItemDao;
import com.joelr.MusicGear.model.GearItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GearItemService {

    @Autowired
    private GearItemDao gearItemDao;

    // Get gear items by name or type
    public List<GearItem> getGearItemsByNameOrType(String name, String type){
        List<GearItem> gearItems = new ArrayList<>();
        if(!type.equals("") && !name.equals("")){
            return gearItemDao.getGearItemsByNameAndType("%" + name + "%", "%" + type + "%");
        } else if(!type.equals("")){
            return gearItemDao.getGearItemsByType("%" + type + "%");
        } else if(!name.equals("")){
            return gearItemDao.getGearItemsByName("%" + name + "%");
        }
        return gearItemDao.getGearItems();
    }

    // Get gear item by id
    public GearItem getGearItemById(int id) {
        return gearItemDao.getGearItemById(id);
    }

    // Add gear item
    public GearItem addGearItem(GearItem gearItem) {
        return gearItemDao.addGearItem(gearItem);
    }

    // Update gear item
    public GearItem updateGearItem(int id, GearItem updatedGearItem) {
        updatedGearItem.setGearId(id);
        return gearItemDao.updateGearItem(updatedGearItem);
    }

    // Remove gear item
    public void removeGearItem(int id) {
            gearItemDao.removeGearItem(id);
    }

}
