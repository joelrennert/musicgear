package com.joelr.musicgear.model;

public class GearItem {

    private int gearId;
    private String type;
    private String name;
    private String description;
    private Boolean vintage;

    public GearItem() {
    }

    public GearItem(int gearId, String type, String name, String description, Boolean vintage) {
        this.gearId = gearId;
        this.type = type;
        this.name = name;
        this.description = description;
        this.vintage = vintage;
    }

    public int getGearId() {
        return gearId;
    }

    public void setGearId(int gearId) {
        this.gearId = gearId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getVintage() {
        return vintage;
    }

    public void setVintage(Boolean vintage) {
        this.vintage = vintage;
    }

    @Override
    public String toString() {
        return String.format(
                "GearItem{gearId=%d, type='%s', name='%s', description='%s', vintage=%b}",
                gearId, type, name, description, vintage
        );
    }
}