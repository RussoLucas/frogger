package com.frogger.game.components;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.TimeUtils;

import java.awt.*;

import static com.frogger.game.enums.TrunkEnum.TRUNK_HEIGHT;
import static com.frogger.game.enums.TrunkEnum.TRUNK_WIDTH;

public class Trunk {
    private Texture imgTrunk;

    private Rectangle trunk;

    private static long lastTrunkTime;

    public Trunk(int yPosition){
        trunk = new Rectangle();

        trunk.x = -200;
        trunk.y = yPosition;

        trunk.width = TRUNK_WIDTH.getValue();
        trunk.height = TRUNK_HEIGHT.getValue();

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
