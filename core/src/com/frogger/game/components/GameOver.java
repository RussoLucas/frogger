package com.frogger.game.components;

import com.badlogic.gdx.graphics.Texture;

public class GameOver {
    private Texture gameOverImg;

    public GameOver(){
        this.gameOverImg = new Texture("game-over.png");
    }

    public Texture getGameOver() {
        return gameOverImg;
    }
}
