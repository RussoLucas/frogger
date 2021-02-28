package com.frogger.game.components;

import com.badlogic.gdx.graphics.Texture;

public class FinishLine extends ImmutableComponents {
    private Texture finishLine;

    public FinishLine(){
        this.finishLine = new Texture("finish-line.png");
    }

    @Override
    public Texture getTexture() {
        return this.finishLine;
    }
}
