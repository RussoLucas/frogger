package com.frogger.game.trunk;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.TimeUtils;

import java.awt.*;

public class Trunk {
    private Texture imgTrunk;

    private Rectangle trunk;

    private static long lastTrunkTime;

    public Trunk(int yPosition){
        trunk = new Rectangle();

        trunk.x = -200;
        trunk.y = yPosition;

        trunk.width = 200;
        trunk.height = 40;

        imgTrunk = new Texture("trunk.png");

        lastTrunkTime = TimeUtils.nanoTime();
    }

    public Texture getImgTrunk() {
        return imgTrunk;
    }

    public Rectangle getTrunk() {
        return trunk;
    }

    public static long getLastTrunkTime() {
        return lastTrunkTime;
    }
}
