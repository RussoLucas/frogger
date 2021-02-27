package com.frogger.game.components;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.TimeUtils;

import java.awt.*;

import static com.frogger.game.enums.CarEnum.CAR_HEIGHT;
import static com.frogger.game.enums.CarEnum.CAR_WIDTH;

public class Car {
    private Texture imgCar;

    private TextureRegion spriteCar;

    private Rectangle car;

    private static long lastCarTime;

    public Car(int yPosition){
        car = new Rectangle();
        car.x = -60;

        car.y = yPosition;
        car.width = CAR_WIDTH.getValue();
        car.height = CAR_HEIGHT.getValue() ;

        imgCar = new Texture("cars.png");

        spriteCar = new TextureRegion(imgCar,0,50,CAR_WIDTH.getValue(),CAR_HEIGHT.getValue());

        lastCarTime = TimeUtils.nanoTime();
    }

    public TextureRegion getRandomImgCar() {
        return spriteCar;
    }
    public Rectangle getCar(){ return car; }
    public static long getLastCarTime() {
        return lastCarTime;
    }
}
