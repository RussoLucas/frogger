package com.frogger.game.components;

import com.badlogic.gdx.graphics.Texture;

public class FroggerTitle {
    private Texture froggerTitleImg;

    public FroggerTitle(){
        this.froggerTitleImg = new Texture("frogger-title.png");
    }

    public Texture getFroggerTitle() {
        return froggerTitleImg;
    }
}
