package com.frogger.game;

import com.badlogic.gdx.graphics.Texture;

public class RestGround {

    private Texture restGround;

    public RestGround(){
        this.restGround = new Texture("rest-ground.png");
    }

    public Texture getRestGround() {
        return restGround;
    }
}
