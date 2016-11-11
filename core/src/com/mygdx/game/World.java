package com.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;

public class World {

	private Gun gun;
	private ArrayList<Ball> balls;
	private Walls walls;
	private BoxesSystem boxesSystem;
	private boolean isShoot;
	private int score;

	public World() {
		isShoot = false;
		score = 0;
		gun = new Gun(this);
		balls = new ArrayList<Ball>();
		walls = new Walls();
		boxesSystem = new BoxesSystem();
	}

	public ArrayList<Ball> getBalls() {
		return balls;
	}

	public Walls getWalls() {
		return this.walls;
	}

	public Gun getGun() {
		return this.gun;
	}

	public BoxesSystem getBoxSystem() {
		return this.boxesSystem;
	}
	
	public int getScore () {
		return score;
	}

	private void makeBall(int x, int y, float rotation) {
		balls.add(new Ball(x, y, rotation, this));
	}

	public void shootBall() {
		Vector2 pos = gun.getShootPosition();
		makeBall((int) pos.x, (int) pos.y, gun.getRotation());
		isShoot = true;
	}

	private void removeOutBall() {
		for (int i = 0; i < balls.size(); i++) {
			Ball ball = balls.get(i);
			if (ball.shouldRemoveBall()) {
				balls.remove(i);
			}
		}
	}

	private void updateBalls(float delta) {
		for (int i = 0; i < balls.size(); i++) {
			Ball ball = balls.get(i);
			ball.update(delta);
		}
	}
	
	public int degreeOfNormalLineThatBallhit(float x, float y, float lastX, float lastY, float direction) {
		if (walls.isHitWall((int)x,(int) y)) {
			return walls.degreeOfNormalLine((int) x, (int) y);
		} else {
			int degree = boxesSystem.degreeOfNormalLine(x, y, lastX, lastY, direction, Ball.damage);
			if (degree >= 0) {
				return degree;
			} else {
				return -1;
			}
		}
	}

	public int degreeOfNormalLineThatLinehit(float x, float y, float lastX, float lastY, float direction) {
		if (walls.isHitWall((int)x, (int)y)) {
			return walls.degreeOfNormalLine((int)x, (int)y);
		} else {
			int degree = boxesSystem.degreeOfNormalLine(x, y, lastX, lastY, direction,0);
			if (degree >= 0) {
				return degree;
			} else {
				return -1;
			}
		}
	}
	
	public boolean inBounceInterval() {
		if (balls.size() >= 0 && isShoot == true) {
			return true;
		}
		return false;
	}
	
	private void endTurn() {
		if (balls.size() == 0 && isShoot == true) {
			boxesSystem.dropBox();
			boxesSystem.randomGenerateBoxes();
			gun.setStop(false);
			isShoot = false;
			score ++;
			gun.increaseMaxBalls();
		}
	}
	
	private void skip (float delta) {
		if (Gdx.input.isKeyJustPressed(Keys.Z) && inBounceInterval()) {
			while (inBounceInterval()) {
				update(delta);
			}
		}
	}

	public void update(float delta) {
		gun.update(delta);
		removeOutBall();
		updateBalls(delta);
		endTurn();
		boxesSystem.clearZeroBox();
		skip(delta);
	}
}
