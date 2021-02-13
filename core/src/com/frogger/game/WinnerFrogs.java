package com.frogger.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class WinnerFrogs extends ApplicationAdapter {

    SpriteBatch batch;
    private Texture frogImg;
    private TextureRegion frogWinnerSprite;
    private int frogWidth;
    private int frogHeight;
    private int winnersPositionY;

    public WinnerFrogs(){
        batch = new SpriteBatch();

        this.frogWidth = 40;
        this.frogHeight = 40;

        this.frogImg = new Texture("frog.png");

        this.frogWinnerSprite = new TextureRegion(frogImg,50,0,this.frogWidth,this.frogHeight);

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

    @Override
    public void create() {

    }

    @Override
    public void render() {

    }

    @Override
    public void dispose() {

    }
}
