package com.frogger.game;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Frog {
    private Texture frogImg;
    private TextureRegion frogSpriteDown;
    private TextureRegion frogSpriteUp;
    private TextureRegion frogSpriteRight;
    private TextureRegion frogSpriteLeft;
    private int frogPositionX;
    private int frogPositionY;
    private int frogWidth;
    private int frogHeight;

    public Frog(){
        this.frogWidth = 40;
        this.frogHeight = 40;

        this.frogImg = new Texture("frog.png");
        this.frogSpriteUp = new TextureRegion(frogImg,50,150,this.frogWidth,this.frogHeight);
        this.frogSpriteDown = new TextureRegion(frogImg,50,0,this.frogWidth,this.frogHeight);
        this.frogSpriteLeft = new TextureRegion(frogImg,50,50,this.frogWidth,this.frogHeight);
        this.frogSpriteRight = new TextureRegion(frogImg,50,100,this.frogWidth,this.frogHeight);

        this.frogPositionX = 0;
        this.frogPositionY = 0;
    }

    public TextureRegion getFrogSprite(int lastKeyPressed) {
        if(lastKeyPressed == Input.Keys.DOWN){
            return frogSpriteDown;
        }else if(lastKeyPressed == Input.Keys.UP){
            return frogSpriteUp;
        }else if(lastKeyPressed == Input.Keys.LEFT){
            return frogSpriteLeft;
        }else if(lastKeyPressed == Input.Keys.RIGHT){
            return frogSpriteRight;
        }else
            return frogSpriteUp;
    }

    public void updateFrogPositionXToLeft(){
        this.frogPositionX = this.frogPositionX - 70;
    }


    public void updateFrogPositionXToRight(){
        this.frogPositionX = this.frogPositionX + 70;
    }

    public void updateFrogPositionYToDown(){
        this.frogPositionY = this.frogPositionY - 60;
    }

    public void updateFrogPositionYToUp(){
        this.frogPositionY = this.frogPositionY + 60;
    }

    public void verifyFrogPosition(){
        if(frogPositionX <=0){
            this.frogPositionX = 0;
        }else if(frogPositionX > 650){
            this.frogPositionX = 650;
        }

        if(frogPositionY <= 0){
            this.frogPositionY = 0;
        }else if(frogPositionY > 560){
            this.frogPositionY = 560;
        }
    }

    public int getFrogPositionX() {
        return frogPositionX;
    }

    public int getFrogPositionY() {
        return frogPositionY;
    }
}
