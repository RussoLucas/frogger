package com.frogger.game.frogs;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
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

    private Sound froggerHop;
    private Sound froggerSquash;

    public Frog(){

        this.froggerHop = Gdx.audio.newSound(Gdx.files.internal("sounds/sound-frogger-hop.wav"));
        this.froggerSquash = Gdx.audio.newSound(Gdx.files.internal("sounds/sound-frogger-squash.wav"));

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
     public void soundFroggerHop(){
         froggerHop.play(0.4f);
     }

     public void soundFroggerSquash(){
        froggerSquash.play(0.4f);
     }
}
