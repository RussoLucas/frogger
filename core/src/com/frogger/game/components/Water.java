package com.frogger.game.components;

import com.badlogic.gdx.graphics.Texture;

import java.awt.*;

public class Water {
    private Texture imgWater;

    private Rectangle water;

    public Water(){
        water = new Rectangle();

        water.x = 0;
        water.y = 390;

        water.width = 700;
        water.height = 310;

        imgWater = new Texture("water.jpg");
    }

    public Texture getImgWater() {
        return imgWater;
    }

    public Rectangle getWater() {
        return water;
    }
}
