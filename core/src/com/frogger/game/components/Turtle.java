package com.frogger.game.components;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.TimeUtils;

import java.awt.*;

import static com.frogger.game.enums.TurtleEnum.TURTLE_HEIGHT;
import static com.frogger.game.enums.TurtleEnum.TURTLE_WIDTH;

public class Turtle {
    private Texture imgTurtle;

    private Rectangle turtle;

    private static long lastTurtleTime;

    public Turtle(int yPosition){
        turtle = new Rectangle();

        turtle.x = 780;
        turtle.y = yPosition;

        turtle.width = TURTLE_WIDTH.getValue();
        turtle.height = TURTLE_HEIGHT.getValue();

        imgTurtle = new Texture("turtle.png");

        lastTurtleTime = TimeUtils.nanoTime();
    }

    public Texture getImgTurtle() {
        return imgTurtle;
    }

    public Rectangle getTurtle() {
        return turtle;
    }

    public static long getLastTurtleTime() {
        return lastTurtleTime;
    }
}
