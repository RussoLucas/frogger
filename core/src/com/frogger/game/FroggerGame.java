package com.frogger.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;

import static java.lang.Boolean.*;

public class FroggerGame extends ApplicationAdapter {

	SpriteBatch batch;
	private Frog frog;
	private WinnerFrogs winnerFrogs;
	private RestGround restGround;
	private FinishLine finishLine;
	private int lastKeyPressed;
	private int winnerController;

	@Override
	public void create () {
		batch = new SpriteBatch();
		frog = new Frog();
		winnerFrogs = new WinnerFrogs();
		restGround = new RestGround();
		finishLine = new FinishLine();

		this.winnerController = 0;
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 0);

		batch.begin();

		batch.draw(restGround.getRestGround(),0,0);
		batch.draw(restGround.getRestGround(),350,0);
		batch.draw(restGround.getRestGround(),0,355);
		batch.draw(restGround.getRestGround(),350,355);

		batch.draw(finishLine.getFinishLine(), 0,650);

		whichKeyPressed();//verifica a tecla pressionada pelo usuário e atualiza a posição no eixo x ou y do sapo


		if(winnerController !=0 ){
			winnerFrogs.draw(winnerController);
		}

		frog.verifyFrogPosition(); //alterar depois. Recomendado que a classe render nao tenha responsabilidades que nao relacionadas a de renderização de elementos na tela

		if(isFrogInFinishLine()){//alterar depois. Recomendado que a classe render nao tenha responsabilidades que nao relacionadas a de renderização de elementos na tela

			frog.setFrogPositionX(0);
			frog.setFrogPositionY(0);

			batch.draw(frog.getFrogSprite(lastKeyPressed),frog.getFrogPositionX(),frog.getFrogPositionY());
		}else{
			batch.draw(frog.getFrogSprite(lastKeyPressed),frog.getFrogPositionX(),frog.getFrogPositionY());
		};

		if(this.winnerController == 5){ //condicional para acabar o jogo || alterar depois. Recomendado que a classe render nao tenha responsabilidades que nao relacionadas a de renderização de elementos na tela
			//adicionar aqui uma tela de vitória
			Gdx.app.exit();
		}

		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}

	private void whichKeyPressed(){
		if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)){
			frog.updateFrogPositionXToLeft();
			lastKeyPressed = Input.Keys.LEFT;
		}
		if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)){
			frog.updateFrogPositionXToRight();
			lastKeyPressed = Input.Keys.RIGHT;
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.UP)){
			frog.updateFrogPositionYToUp();
			lastKeyPressed = Input.Keys.UP;
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN)){
			frog.updateFrogPositionYToDown();
			lastKeyPressed = Input.Keys.DOWN;
		}
	}

	private boolean isFrogInFinishLine() {
		if (frog.isTouchFinishLine()) {
			this.winnerController++;
			System.out.println(winnerController);
			frog.setTouchFinishLine(FALSE);
			return TRUE;
		}/*else{
			frog.setTouchFinishLine(FALSE);
			return FALSE;
		}*/
		return FALSE;
	}
}
