package com.santillanj.rplife_z.Models;

/**
 * Created by Jeremy on 7/8/2018.
 */

public class CharacterParts {
    private String intType;
    private String partType;
    private String partName;
    private int partImg;

    public CharacterParts(String intType, String partType, String partName, int partImg) {
        this.intType = intType;
        this.partType = partType;
        this.partName = partName;
        this.partImg = partImg;
    }

    public String getIntType() {
        return intType;
    }

    public void setIntType(String intType) {
        this.intType = intType;
    }

    public String getPartType() {
        return partType;
    }

    public void setPartType(String partType) {
        this.partType = partType;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public int getPartImg() {
        return partImg;
    }

    public void setPartImg(int partImg) {
        this.partImg = partImg;
    }
}
