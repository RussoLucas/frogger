package com.frogger.game;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import static java.lang.Boolean.*;

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
    private boolean touchFinishLine;

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

        this.touchFinishLine = FALSE;
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
        this.frogPositionX = this.frogPositionX - 60;
    }


    public void updateFrogPositionXToRight(){
        this.frogPositionX = this.frogPositionX + 60;
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
        }else if(frogPositionY > 660){
            this.frogPositionY = 660;
        }
    }

    public boolean isTouchFinishLine() {
        if(this.frogPositionY > 600){
            this.touchFinishLine = TRUE;
            return touchFinishLine;
        }
        this.touchFinishLine = FALSE;
        return touchFinishLine;
    }

    public int getFrogPositionX() {
        return frogPositionX;
    }

    public void setFrogPositionX(int frogPositionX) {
        this.frogPositionX = frogPositionX;
    }

    public void setFrogPositionY(int frogPositionY) {
        this.frogPositionY = frogPositionY;
    }

    public int getFrogPositionY() {
        return frogPositionY;
    }

    public TextureRegion getFrogSpriteDown() {
        return frogSpriteDown;
    }

    public void setTouchFinishLine(boolean touchFinishLine) {
        this.touchFinishLine = touchFinishLine;
    }



}
