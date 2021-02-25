package com.frogger.game.enums;

public enum CarEnum {CAR_WIDTH(90), CAR_HEIGHT(50);

    private int value;

    CarEnum(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
