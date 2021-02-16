package com.frogger.game.screens;

import java.util.Random;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.TimeUtils;
import com.frogger.game.cars.Car;
import com.frogger.game.components.FinishLine;
import com.frogger.game.frogs.Frog;
import com.frogger.game.components.RestGround;
import com.frogger.game.frogs.WinnerFrogs;
import com.frogger.game.rectangles.FrogRectangle;

import java.util.Iterator;

import static java.lang.Boolean.*;

public class FroggerGame extends ApplicationAdapter {

	SpriteBatch batch;
	private OrthographicCamera camera;

	private Frog frog;
	private WinnerFrogs winnerFrogs;
	private RestGround restGround;
	private FinishLine finishLine;
	private Array<Car> carListFirstQueue;

	private int lastKeyPressed;
	private int winnerController;

	private FrogRectangle frogRectangle;

	private int lifes;

	@Override
	public void create () {

		this.frogRectangle = new FrogRectangle();

		batch = new SpriteBatch();

		camera = new OrthographicCamera();

		camera.setToOrtho(false,700,700);

		frog = new Frog();

		carListFirstQueue = new Array<Car>();
		carListFirstQueue.add(new Car());

		winnerFrogs = new WinnerFrogs();
		restGround = new RestGround();
		finishLine = new FinishLine();

		this.winnerController = 0;
		this.lifes = 5;
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 0);

		camera.update();

		batch.setProjectionMatrix(camera.combined);

		batch.begin();

		batch.draw(restGround.getRestGround(),0,0);
		batch.draw(restGround.getRestGround(),350,0);
		batch.draw(restGround.getRestGround(),0,355);
		batch.draw(restGround.getRestGround(),350,355);

		batch.draw(finishLine.getFinishLine(), 0,650);


		for(Car car : carListFirstQueue){
			batch.draw(carListFirstQueue.first().getImgCar(), car.getCar().x,car.getCar().y);
		}

		whichKeyPressed();//verifica a tecla pressionada pelo usuário e atualiza a posição no eixo x ou y do sapo

		if(TimeUtils.nanoTime() - Car.getLastCarTime() > 2000000000){
			carListFirstQueue.add(new Car());
		}

		Iterator<Car> iter = carListFirstQueue.iterator();

		while(iter.hasNext()){
			Car car = iter.next();

			car.getCar().x += 3;

			if(car.getCar().x + 90 > 700){
				iter.remove();
			}

			if(car.getCar().intersects(frogRectangle.getFrog())) {
				lifes--;
				System.out.println(lifes);
				frogRectangle.setFrogRectangleY(0);

				batch.draw(frog.getFrogSprite(lastKeyPressed), frogRectangle.getFrogRectangleX(), frogRectangle.getFrogRectangleY());
				if (lifes == 0) {
					//adicionar chamada da tela de jogar novamente
					Gdx.app.exit();
				}
			}
		}



		if(winnerController !=0 ){
			winnerFrogs.draw(winnerController);
		}

		frogRectangle.verifyFrogPosition(); //alterar depois. Recomendado que a classe render nao tenha responsabilidades que nao relacionadas a de renderização de elementos na tela

		if(isFrogInFinishLine()){//alterar depois. Recomendado que a classe render nao tenha responsabilidades que nao relacionadas a de renderização de elementos na tela

			frogRectangle.setFrogRectangleX(0);
			frogRectangle.setFrogRectangleY(0);

			batch.draw(frog.getFrogSprite(lastKeyPressed),frogRectangle.getFrogRectangleX(),frogRectangle.getFrogRectangleY());
		}else{
			batch.draw(frog.getFrogSprite(lastKeyPressed),frogRectangle.getFrogRectangleX(),frogRectangle.getFrogRectangleY());
		};

		if(this.winnerController == 5){ //condicional para acabar o jogo || alterar depois. Recomendado que a classe render nao tenha responsabilidades que nao relacionadas a de renderização de elementos na tela
			//adicionar aqui uma tela de vitória
//			Gdx.app.exit();
		}

		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}

	private void whichKeyPressed(){
		if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)){
			frogRectangle.updateFrogRectanglePositionToLeft();
			lastKeyPressed = Input.Keys.LEFT;
		}
		if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)){
			frogRectangle.updateFrogRectanglePositionToRight();
			lastKeyPressed = Input.Keys.RIGHT;
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.UP)){
			frogRectangle.updateFrogRectanglePositionToUp();
			lastKeyPressed = Input.Keys.UP;
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN)){
			frogRectangle.updateFrogRectanglePositionToDown();
			lastKeyPressed = Input.Keys.DOWN;
		}
	}

	private boolean isFrogInFinishLine() {
		if (frogRectangle.isTouchFinishLine()) {
			this.winnerController++;
			System.out.println(winnerController);
			frogRectangle.setTouchFinishLine(FALSE);
			return TRUE;
		}
		return FALSE;
	}
}
