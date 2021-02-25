package com.frogger.game.enums;

public enum TurtleEnum {TURTLE_WIDTH(90), TURTLE_HEIGHT(45);

    private int value;

    TurtleEnum(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
