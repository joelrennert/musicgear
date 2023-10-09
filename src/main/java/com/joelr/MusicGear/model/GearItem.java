package com.joelr.MusicGear.model;

public class GearItem {

    private int gearId;
    private String type;
    private String name;
    private String description;
    private Boolean isVintage;

    public GearItem(){
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
        return isVintage;
    }

    public void setVintage(Boolean vintage) {
        isVintage = vintage;
    }

    @Override
    public String toString(){
        return "Product{ " +
                "  id = " + gearId +
                ", type = " + type +
                ", name = " + name +
                ", description = " + description +
                ", isVintage = " + isVintage  +" }";
    }


}
