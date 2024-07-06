package com.joelr.MusicGear.dao;

import com.joelr.MusicGear.model.GearItem;

import java.util.List;

public interface GearItemDao {

    // Get a list of gear items by name or type
    List<GearItem> getGearItemsByNameAndType(String name, String type);

    // Get a list of all gear items
    List<GearItem> getGearItems();

    // Get a single gear item by id
    GearItem getGearItemById(int gearId);

    // Get a list of gear items by name
    List<GearItem> getGearItemsByName(String name);

    // Get a list of gear items by type
    List<GearItem> getGearItemsByType(String type);

    // Add a gear item
    GearItem addGearItem(GearItem gearItem);

    // Update a gear item
    GearItem updateGearItem(GearItem updateGearItem);

    // Update a gear item's type
//    GearItem updateGearItemType(GearItem gearItem, String type);

    // Update a gear item's description
//    GearItem updateGearItemDescription(GearItem gearItem, String description);

    // Delete a gear item
    void removeGearItem(int id);

}
