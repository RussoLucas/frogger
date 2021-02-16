package com.frogger.game.frogs;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import static com.frogger.game.frogs.FrogsEnum.FROG_HEIGHT;
import static com.frogger.game.frogs.FrogsEnum.FROG_WIDTH;

public class Frog {
    private Texture frogImg;
    private TextureRegion frogSpriteDown;
    private TextureRegion frogSpriteUp;
    private TextureRegion frogSpriteRight;
    private TextureRegion frogSpriteLeft;


    public Frog(){

        this.frogImg = new Texture("frog.png");
        this.frogSpriteUp = new TextureRegion(frogImg,50,150,FROG_WIDTH.getValue(),FROG_HEIGHT.getValue());
        this.frogSpriteDown = new TextureRegion(frogImg,50,0,FROG_WIDTH.getValue(),FROG_HEIGHT.getValue());
        this.frogSpriteLeft = new TextureRegion(frogImg,50,50,FROG_WIDTH.getValue(),FROG_HEIGHT.getValue());
        this.frogSpriteRight = new TextureRegion(frogImg,50,100,FROG_WIDTH.getValue(),FROG_HEIGHT.getValue());

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
}
