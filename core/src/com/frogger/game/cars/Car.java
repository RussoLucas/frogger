package com.frogger.game.cars;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.TimeUtils;

import java.awt.*;
import java.util.Random;

public class Car {
    private Texture imgCar;

    private TextureRegion blueCar;
    private TextureRegion greenCar;
    private TextureRegion yellowCar;


    private int colorCar;

    private Rectangle car;

    private static long lastCarTime;

    public Car(int yPosition){
        car = new Rectangle();
        car.y = yPosition;
        car.width = 60;
        car.height = 40;

        Random rand = new Random();
        int colorCar = rand.nextInt(3) + 1;

        imgCar = new Texture("cars.png");

        blueCar = new TextureRegion(imgCar,0,50,90,50);
        greenCar = new TextureRegion(imgCar, 90, 50, 90,50);
        yellowCar = new TextureRegion(imgCar,180,50,90,50);

        lastCarTime = TimeUtils.nanoTime();
    }

    public TextureRegion getRandomImgCar() {
        return blueCar;
    }
    public Rectangle getCar(){ return car; }
    public static long getLastCarTime() {
        return lastCarTime;
    }
}
