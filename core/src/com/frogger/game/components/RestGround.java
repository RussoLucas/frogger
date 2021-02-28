package com.frogger.game.components;

import com.badlogic.gdx.graphics.Texture;

public class RestGround extends ImmutableComponents {

    private Texture restGround;

    public RestGround(){
        this.restGround = new Texture("rest-ground.png");
    }

    @Override
    public Texture getTexture() {
        return restGround;
    }
}
