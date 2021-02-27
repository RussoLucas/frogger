package com.frogger.game.components;

import com.badlogic.gdx.graphics.Texture;

public class FrogBackgroundInitialScreen {
    private Texture frogBackgroundInitialScreen;

    public FrogBackgroundInitialScreen(){
        this.frogBackgroundInitialScreen = new Texture("frogger-title.png");
    }

    public Texture getFroggerTitle() {
        return frogBackgroundInitialScreen;
    }
}
