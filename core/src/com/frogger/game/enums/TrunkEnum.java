package com.frogger.game.enums;

public enum TrunkEnum {TRUNK_WIDTH( 200), TRUNK_HEIGHT(40);

    private int value;

    TrunkEnum(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
