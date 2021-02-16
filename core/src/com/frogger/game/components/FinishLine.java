package com.frogger.game.components;

import com.badlogic.gdx.graphics.Texture;

public class FinishLine {
    private Texture finishLine;

    public FinishLine(){
        this.finishLine = new Texture("finish-line.png");
    }

    public Texture getFinishLine() {
        return finishLine;
    }
}
