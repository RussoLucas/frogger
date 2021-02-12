package com.frogger.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;

public class FroggerGame extends ApplicationAdapter {
	SpriteBatch batch;
	private Frog frog;
	private int lastKeyPressed;

	@Override
	public void create () {
		batch = new SpriteBatch();
		frog = new Frog();
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 0);

		batch.begin();

		whichKeyPressed();//verifica a tecla pressionada pelo usuário e atualiza a posição no eixo x ou y do sapo

		frog.verifyFrogPosition(); //alterar depois. Recomendado que a classe render nao tenha responsabilidades que nao relacionadas a de renderização de elementos na tela

		batch.draw(frog.getFrogSprite(lastKeyPressed), frog.getFrogPositionX(),frog.getFrogPositionY());

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
}
