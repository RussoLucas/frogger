package com.frogger.game.screens;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.TimeUtils;
import com.frogger.game.components.*;
import com.frogger.game.rectangles.FrogRectangle;

import java.util.Iterator;
import java.util.Random;

import static com.frogger.game.enums.FrogsEnum.FROG_HEIGHT;
import static com.frogger.game.enums.FrogsEnum.FROG_WIDTH;
import static java.lang.Boolean.*;

public class FroggerGame extends Game {

	private SpriteBatch batch;
	private OrthographicCamera camera;
	private FroggerGame game;

	private Frog frog;
	private WinnerFrogs winnerFrogs;
	private RestGround restGround;
	private FinishLine finishLine;
	private FroggerTitle froggerTitle;

	private Water water;
	private Trunk trunk;
	private Turtle turtle;

	private Array<Car> carList;
	private Array<Trunk> trunkList;

	private Array<Turtle> turtleList;

	private int lastKeyPressed;
	private int winnerController;

	private FrogRectangle frogRectangle;

	private Music music;

	private int turtleSpeed;
	private int carSpeed;
	private int trunkSpeed;

	private BitmapFont textLife;
	private BitmapFont textPoints;

	private int points;

	private int lifes;

	@Override
	public void create () {

		this.frogRectangle = new FrogRectangle();
		batch = new SpriteBatch();

		camera = new OrthographicCamera();

		camera.setToOrtho(false,700,700);

		textLife = new BitmapFont();
		textPoints = new BitmapFont();

//		music = new Music();

		frog = new Frog();

		trunk = new Trunk(420);
		turtle = new Turtle(480);

		carList = new Array<Car>();
		carList.add(new Car(60));
		carSpeed = 6;

		turtleList = new Array<Turtle>();
		turtleList.add(turtle);
		turtleSpeed = 3;

		trunkList = new Array<Trunk>();
		trunkList.add(trunk);
		trunkSpeed = 3;

		winnerFrogs = new WinnerFrogs();
		restGround = new RestGround();
		finishLine = new FinishLine();
		froggerTitle = new FroggerTitle();

		water = new Water();

		this.winnerController = 0;
		this.lifes = 5;
	}

	@Override
	public void render () {

		boolean isFrogOnTrunk = false;
		boolean isFrogOnTurtle =  false;

		ScreenUtils.clear(0, 0, 0, 0);

		batch.begin();

		textLife.draw(batch, "VIDAS: " + lifes, 20, 770);
		textPoints.draw(batch,"PONTOS: " + points,20,750);

		batch.draw(restGround.getRestGround(),0,0);
		batch.draw(restGround.getRestGround(),350,0);
		batch.draw(restGround.getRestGround(),0,355);
		batch.draw(restGround.getRestGround(),350,355);

		batch.draw(water.getImgWater(),water.getWater().x,water.getWater().y,water.getWater().width,water.getWater().height);

		batch.draw(finishLine.getFinishLine(), 0,650);

		batch.draw(froggerTitle.getFroggerTitle(), 200,735 );

		renderCarsQueue(carSpeed);

		renderTurtleQueue(turtleSpeed);

		renderTrunksQueue(trunkSpeed);

		whichKeyPressed();

		if(winnerController !=0 ){
			winnerFrogs.draw(winnerController);
		}

		frogRectangle.verifyFrogPosition();

		if(isFrogInFinishLine()){

			carSpeed += 2;
			trunkSpeed ++;
			turtleSpeed ++;

			points += lifes * 1000;

			lifes--;

			frogRectangle.setFrogRectangleX(300);

			frogRectangle.setFrogRectangleY(0);

			batch.draw(frog.getFrogSprite(lastKeyPressed),frogRectangle.getFrogRectangleX(),frogRectangle.getFrogRectangleY(),FROG_WIDTH.getValue(),FROG_HEIGHT.getValue());
		}else{
			batch.draw(frog.getFrogSprite(lastKeyPressed),frogRectangle.getFrogRectangleX(),frogRectangle.getFrogRectangleY(),FROG_WIDTH.getValue(),FROG_HEIGHT.getValue());
		}

		for (Trunk trunk: trunkList) {
			if(trunk.getTrunk().contains(frogRectangle.getFrog())){
				isFrogOnTrunk = true;
			}
		}

		for (Turtle turtle: turtleList){
			if(turtle.getTurtle().contains(frogRectangle.getFrog())){
				isFrogOnTurtle = true;
			}
		}

		boolean isFrogOnWater = (frogRectangle.getFrog().y > 400 && !isFrogOnTrunk && !isFrogOnTurtle);

		if( isFrogOnWater){
			lifes--;

			frog.soundFroggerPlunk();

			frogRectangle.setFrogRectangleX(300);

			frogRectangle.setFrogRectangleY(0);

			batch.draw(frog.getFrogSprite(lastKeyPressed),frogRectangle.getFrogRectangleX(),frogRectangle.getFrogRectangleY(),FROG_WIDTH.getValue(),FROG_HEIGHT.getValue());
		}


		if (lifes == 0 && points == 0) {
			//Gdx.app.exit();
		}else if(lifes == 0){
			System.out.println("vitoria");
		}

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

			frog.soundFroggerExtra();

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

				frog.soundFroggerSquash();

				frogRectangle.setFrogRectangleY(0);

				batch.draw(frog.getFrogSprite(lastKeyPressed), frogRectangle.getFrogRectangleX(), frogRectangle.getFrogRectangleY());

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

				frogRectangle.getFrog().x += speed;

				batch.draw(frog.getFrogSprite(lastKeyPressed), frogRectangle.getFrogRectangleX(), frogRectangle.getFrogRectangleY());

				if (trunk.getTrunk().x > 700) {
					iter.remove();
				}
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

				frogRectangle.getFrog().x -= speed;
				batch.draw(frog.getFrogSprite(lastKeyPressed), frogRectangle.getFrogRectangleX(), frogRectangle.getFrogRectangleY());

				if (turtle.getTurtle().x < 0) {
					iter.remove();
				}
			}
		}
	}

	public SpriteBatch getBatch() {
		return batch;
	}
}
