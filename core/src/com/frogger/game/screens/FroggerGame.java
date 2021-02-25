package com.frogger.game.screens;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.TimeUtils;
import com.frogger.game.components.Car;
import com.frogger.game.components.FinishLine;
import com.frogger.game.components.Water;
import com.frogger.game.components.Frog;
import com.frogger.game.components.RestGround;
import com.frogger.game.components.WinnerFrogs;
import com.frogger.game.rectangles.FrogRectangle;
import com.frogger.game.components.Trunk;
import com.frogger.game.components.Turtle;

import java.util.Iterator;
import java.util.Random;

import static java.lang.Boolean.*;

public class FroggerGame extends ApplicationAdapter {

	SpriteBatch batch;
	private OrthographicCamera camera;

	private Frog frog;
	private WinnerFrogs winnerFrogs;
	private RestGround restGround;
	private FinishLine finishLine;
	private Water water;

	private Trunk trunk;
	private Turtle turtle;

	private TextureRegion carSprite;
	private Array<Car> carList;
	private Array<Trunk> trunkList;
	private Array<Turtle> turtleList;

	private Music froggerMusic;

	private int lastKeyPressed;
	private int winnerController;

	private FrogRectangle frogRectangle;

	private int isOnTrunk;
	private int isOnTurtle;

	private int lifes;

	@Override
	public void create () {

		this.frogRectangle = new FrogRectangle();

//		playMusic();

		batch = new SpriteBatch();

		camera = new OrthographicCamera();

		camera.setToOrtho(false,700,700);

		frog = new Frog();

		trunk = new Trunk(420);
		turtle = new Turtle(480);

		carList = new Array<Car>();
		carList.add(new Car(60));

		turtleList = new Array<Turtle>();
		turtleList.add(turtle);
		isOnTurtle = 0;

		trunkList = new Array<Trunk>();
		trunkList.add(trunk);
		isOnTrunk = 0;

		winnerFrogs = new WinnerFrogs();
		restGround = new RestGround();
		finishLine = new FinishLine();
		water = new Water();

		this.winnerController = 0;
		this.lifes = 5;
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 0);
		camera.update();


		batch.setProjectionMatrix(camera.combined);

		batch.begin();


		System.out.println("PosY" + frogRectangle.getFrog().y);
		batch.draw(restGround.getRestGround(),0,0);
		batch.draw(restGround.getRestGround(),350,0);
		batch.draw(restGround.getRestGround(),0,355);
		batch.draw(restGround.getRestGround(),350,355);

		batch.draw(water.getImgWater(),water.getWater().x,water.getWater().y,water.getWater().width,water.getWater().height);

		batch.draw(finishLine.getFinishLine(), 0,650);

		renderCarsQueue(6);

		renderTurtleQueue(3);

		renderTrunksQueue(3);

		whichKeyPressed();

		if(winnerController !=0 ){
			winnerFrogs.draw(winnerController);
		}

		frogRectangle.verifyFrogPosition();

		if(isFrogInFinishLine()){

			frogRectangle.setFrogRectangleX(300);

			frogRectangle.setFrogRectangleY(0);

			batch.draw(frog.getFrogSprite(lastKeyPressed),frogRectangle.getFrogRectangleX(),frogRectangle.getFrogRectangleY(),40,40);
		}else{
			batch.draw(frog.getFrogSprite(lastKeyPressed),frogRectangle.getFrogRectangleX(),frogRectangle.getFrogRectangleY(),40,40);
		};

		if(this.winnerController == 5){
			//adicionar aqui uma tela de vitória
			//Gdx.app.exit();
		}

		System.out.println(isOnTrunk);
		System.out.println(isOnTurtle);


//		if( isOnTurtle == 0 && isOnTrunk == 0) {
//
//			frogRectangle.setFrogRectangleX(300);
//
//			frogRectangle.setFrogRectangleY(0);
//
//			batch.draw(frog.getFrogSprite(lastKeyPressed), frogRectangle.getFrogRectangleX(), frogRectangle.getFrogRectangleY(), 40, 40);
//		}
//
//		isOnTurtle = 0;
//		isOnTrunk = 0;

		batch.end();
	}

	@Override
	public void dispose () {
		batch.dispose();
	}

	private void whichKeyPressed(){
		if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)){
			frog.soundFroggerHop();
			frogRectangle.updateFrogRectanglePositionToLeft();
			lastKeyPressed = Input.Keys.LEFT;
		}
		if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)){
			frog.soundFroggerHop();
			frogRectangle.updateFrogRectanglePositionToRight();
			lastKeyPressed = Input.Keys.RIGHT;
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.UP)){
			frog.soundFroggerHop();
			frogRectangle.updateFrogRectanglePositionToUp();
			lastKeyPressed = Input.Keys.UP;
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN)){
			frog.soundFroggerHop();
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

	private void renderCarsQueue(int speed){

		for(Car car : carList){
			batch.draw(car.getRandomImgCar(), car.getCar().x,car.getCar().y);
		}

		int possibleInitialPositionsY[] = new int[] {60, 120, 180, 240, 300 };

		Random random = new Random();

		int ind = random.nextInt(possibleInitialPositionsY.length);

		if(TimeUtils.nanoTime() - Car.getLastCarTime()> 300000000){
			carList.add(new Car(possibleInitialPositionsY[ind]));
		}

		Iterator<Car> iter = carList.iterator();

		while(iter.hasNext()){
			Car car = iter.next();

			car.getCar().x += speed;

			if(car.getCar().x > 700){
				iter.remove();
			}

			if(car.getCar().intersects(frogRectangle.getFrog())) {

				//teste
				System.out.println(lifes);
				frog.soundFroggerHop();
				frogRectangle.setFrogRectangleY(0);

				batch.draw(frog.getFrogSprite(lastKeyPressed), frogRectangle.getFrogRectangleX(), frogRectangle.getFrogRectangleY());

				if (lifes <= 0) {
					//adicionar chamada da tela de jogar novamente
//					Gdx.app.exit();
				}

				lifes--;
			}
		}
	}

	private void renderTrunksQueue(int speed) {
		for (Trunk trunk : trunkList) {
			batch.draw(trunk.getImgTrunk(), trunk.getTrunk().x, trunk.getTrunk().y, trunk.getTrunk().width, trunk.getTrunk().height);
		}

		int possibleInitialPositionsY[] = new int[]{420, 540};

		Random random = new Random();

		int ind = random.nextInt(possibleInitialPositionsY.length);

		if (TimeUtils.nanoTime() - trunk.getLastTrunkTime() > 1300000000) {
			trunkList.add(new Trunk(possibleInitialPositionsY[ind]));
		}

		Iterator<Trunk> iter = trunkList.iterator();

		while (iter.hasNext()) {
			Trunk trunk = iter.next();

			trunk.getTrunk().x += speed;

			if (trunk.getTrunk().contains(frogRectangle.getFrog())) {

//				water.setOnTrunk(TRUE);

				frogRectangle.getFrog().x += speed;

				batch.draw(frog.getFrogSprite(lastKeyPressed), frogRectangle.getFrogRectangleX(), frogRectangle.getFrogRectangleY());

				if (trunk.getTrunk().x > 700) {
					iter.remove();
				}

				isOnTrunk = 1;

			}
		}
	}

	private void renderTurtleQueue(int speed)      {
		for (Turtle turtle : turtleList) {
			batch.draw(turtle.getImgTurtle(), turtle.getTurtle().x, turtle.getTurtle().y, turtle.getTurtle().width, turtle.getTurtle().height);
		}

		int possibleInitialPositionsY[] = new int[]{480, 600};

		Random random = new Random();

		int ind = random.nextInt(possibleInitialPositionsY.length);

		if (TimeUtils.nanoTime() - turtle.getLastTurtleTime() > 900000000) {
			turtleList.add(new Turtle(possibleInitialPositionsY[ind]));
		}

		Iterator<Turtle> iter = turtleList.iterator();

		while (iter.hasNext()) {
			Turtle turtle = iter.next();

			turtle.getTurtle().x -= speed;


			if (turtle.getTurtle().contains(frogRectangle.getFrog())) {

//				water.setOnTurtle(TRUE);

				frogRectangle.getFrog().x -= speed;
				batch.draw(frog.getFrogSprite(lastKeyPressed), frogRectangle.getFrogRectangleX(), frogRectangle.getFrogRectangleY());

				if (turtle.getTurtle().x < 0) {
					iter.remove();
				}
				isOnTurtle = 1;

			}
		}
	}

	public void playMusic(){
		froggerMusic = Gdx.audio.newMusic(Gdx.files.internal("sounds/frogger-music.wav"));
		froggerMusic.play();
		froggerMusic.setVolume(0.4f);
		froggerMusic.setLooping(true);
		froggerMusic.play();
	}
}
