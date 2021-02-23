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
    private Sound froggerPlunk;

    public Frog(){

        this.froggerHop = Gdx.audio.newSound(Gdx.files.internal("sounds/sound-frogger-hop.wav"));
        this.froggerPlunk = Gdx.audio.newSound(Gdx.files.internal("sounds/sound-frogger-plunk.wav"));

        this.frogImg = new Texture("frog.png");

        this.frogSpriteUp = new TextureRegion(frogImg,50,150,40,40);
        this.frogSpriteDown = new TextureRegion(frogImg,50,0,40,40);
        this.frogSpriteLeft = new TextureRegion(frogImg,50,50,40,40);
        this.frogSpriteRight = new TextureRegion(frogImg,50,100,40,40);

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
        froggerPlunk.play(0.1f);
     }
}
