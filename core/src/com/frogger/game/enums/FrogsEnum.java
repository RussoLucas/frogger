package com.frogger.game.enums;

public enum FrogsEnum { FROG_WIDTH(40), FROG_HEIGHT(40);

    private int value;

    FrogsEnum(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
