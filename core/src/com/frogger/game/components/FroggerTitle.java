package com.frogger.game.components;

import com.badlogic.gdx.graphics.Texture;

public class FroggerTitle extends ImmutableComponents {
    private Texture froggerTitleImg;

    public FroggerTitle(){
        this.froggerTitleImg = new Texture("frogger-title.png");
    }

    @Override
    public Texture getTexture() {
        return froggerTitleImg;
    }
}
