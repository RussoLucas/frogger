package com.frogger.game.enums;

public enum WaterEnum {WATER_WIDTH(700), WATER_HEIGHT(310);

    private int value;

    WaterEnum(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
