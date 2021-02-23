package com.frogger.game.frogs;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import static com.frogger.game.frogs.FrogsEnum.FROG_HEIGHT;
import static com.frogger.game.frogs.FrogsEnum.FROG_WIDTH;

public class WinnerFrogs {

    SpriteBatch batch;
    private Texture frogImg;
    private TextureRegion frogWinnerSprite;
    private int winnersPositionY;


    public WinnerFrogs(){
        batch = new SpriteBatch();

        this.frogImg = new Texture("frog.png");

        this.frogWinnerSprite = new TextureRegion(frogImg,100,0,FROG_WIDTH.getValue(),FROG_HEIGHT.getValue());

        this.winnersPositionY = 660;

    }

    public void draw(int winnerController){
        batch.begin();

        switch (winnerController){
            case 1:
                batch.draw(frogWinnerSprite,25,winnersPositionY);
                break;
            case 2:
                batch.draw(frogWinnerSprite,25,winnersPositionY);
                batch.draw(frogWinnerSprite,180,winnersPositionY);
                break;
            case 3:
                batch.draw(frogWinnerSprite,25,winnersPositionY);
                batch.draw(frogWinnerSprite,180,winnersPositionY);
                batch.draw(frogWinnerSprite,330,winnersPositionY);
                break;
            case 4:
                batch.draw(frogWinnerSprite,25,winnersPositionY);
                batch.draw(frogWinnerSprite,180,winnersPositionY);
                batch.draw(frogWinnerSprite,330,winnersPositionY);
                batch.draw(frogWinnerSprite,470,winnersPositionY);
                break;
            case 5:
                batch.draw(frogWinnerSprite,25,winnersPositionY);
                batch.draw(frogWinnerSprite,180,winnersPositionY);
                batch.draw(frogWinnerSprite,330,winnersPositionY);
                batch.draw(frogWinnerSprite,470,winnersPositionY);
                batch.draw(frogWinnerSprite,645,winnersPositionY);
                break;
        }
        batch.end();
    }
}
