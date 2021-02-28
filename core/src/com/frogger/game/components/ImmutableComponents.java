package com.frogger.game.components;

import com.badlogic.gdx.graphics.Texture;

public class ImmutableComponents {

    private Texture ImmutableTexture;

    public void ImmutableTexture(Texture texture){
        this.ImmutableTexture = texture;
    }

    public Texture getTexture(){
        return this.ImmutableTexture;
    }
}
