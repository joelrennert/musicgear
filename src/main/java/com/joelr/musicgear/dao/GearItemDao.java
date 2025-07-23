package com.joelr.musicgear.dao;

import com.joelr.musicgear.model.GearItem;
import java.util.List;

public interface GearItemDao {

    List<GearItem> getGearItemsByNameAndType(String name, String type);

    List<GearItem> getGearItems();

    GearItem getGearItemById(int gearId);

    List<GearItem> getGearItemsByName(String name);

    List<GearItem> getGearItemsByType(String type);

    GearItem addGearItem(GearItem gearItem);

    GearItem updateGearItem(GearItem updatedGearItem);

    void removeGearItem(int id);
}