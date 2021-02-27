package com.frogger.game.screens;

import com.badlogic.gdx.*;
import com.frogger.game.components.FroggerTitle;


public class InitialScreen implements Screen{

    private FroggerGame game;

    private FroggerTitle froggerTitle;

    public InitialScreen(FroggerGame game){

        froggerTitle = new FroggerTitle();
    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        game.getBatch().begin();
        game.getBatch().draw(froggerTitle.getFroggerTitle(),0,300);
        game.getBatch().end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
