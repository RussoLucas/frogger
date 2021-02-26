package com.frogger.game.components;

import com.badlogic.gdx.Gdx;

public class Music {

    private com.badlogic.gdx.audio.Music froggerMusic;

    public Music(){
        froggerMusic = Gdx.audio.newMusic(Gdx.files.internal("sounds/frogger-music.wav"));
        froggerMusic.play();
        froggerMusic.setVolume(0.3f);
        froggerMusic.setLooping(true);
        froggerMusic.play();
    }
}
