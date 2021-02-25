package com.frogger.game.components;

import static com.frogger.game.enums.WaterEnum.WATER_HEIGHT;
import static com.frogger.game.enums.WaterEnum.WATER_WIDTH;
import static java.lang.Boolean.*;
import com.badlogic.gdx.graphics.Texture;

import java.awt.*;

public class Water {
    private Texture imgWater;

    private Rectangle water;


    public Water(){
        water = new Rectangle();

        water.x = 0;
        water.y = 390;

        water.width = WATER_WIDTH.getValue();
        water.height = WATER_HEIGHT.getValue();

        imgWater = new Texture("water.jpg");

    }

    public Texture getImgWater() {
        return imgWater;
    }

    public Rectangle getWater() {
        return water;
    }

}
