package com.frogger.game.frogs;

public enum FrogsEnum { FROG_WIDTH(40), FROG_HEIGHT(30);

    private int value;

    private FrogsEnum(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
