package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;

public class Gun {

	private int x = 300;
	private int y = 50;
	private float rotation = 0;
	private boolean isStop;
	private int maxBalls;
	private int ballsInQueue;
	private int delay;
	private World world;

	final int width = 30;
	final int height = 50;
	final int Scale = 1;
	final int originX = 15;
	final int originY = 15;

	public Gun(World world) {
		this.world = world;
		maxBalls = 5;
		ballsInQueue = 0;
		isStop = false;
	}

	public void setStop(boolean stop) {
		isStop = stop;
	}
	
	public int getMaxBalls () {
		return maxBalls;
	}
	public void increaseMaxBalls () {
		maxBalls++;
	}

	public Vector2 getPosition() {
		return new Vector2(x, y);
	}

	public float getRotation() {
		return rotation;
	}

	public void update(float delta) {
		float rotateSpeed ;
		if (Gdx.input.isKeyPressed(Keys.SHIFT_LEFT)) {
			rotateSpeed = 0.02f;
		} else {
			rotateSpeed = 1f;
		}
		if (!isStop) {
			if (Gdx.input.isKeyPressed(Keys.LEFT)) {
				rotation += rotateSpeed;
			} else if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
				rotation -= rotateSpeed;
			}
			if (rotation > 85)
				rotation = 85;
			if (rotation < -85)
				rotation = -85;
		}
			shootBall();
		
	}

	private void shootBall() {
		
		if (Gdx.input.isKeyJustPressed(Keys.SPACE) && ballsInQueue == 0 && ! isStop) {
			ballsInQueue = maxBalls;
			setStop(true);
		}	
		if (ballsInQueue > 0 && delay <= 0) {
			world.shootBall();
			ballsInQueue --;
			delay = 3;
		}
		delay --;
		
	}

	public Vector2 getShootPosition() {
		double radian = Math.toRadians(rotation);
		int x = (int) (this.x + originX - (height - originY) * Math.sin(radian));
		int y = (int) (this.y + originY + (height - originY) * Math.cos(radian));
		return new Vector2(x, y);
	}

}