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

	public World() {
		isShoot = true;
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

	private void makeBall(int x, int y, int rotation) {
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

	public int degreeOfNormalLineThatBallhit(int x, int y, int lastX, int lastY) {
		if (walls.isHitWall(x, y)) {
			return walls.degreeOfNormalLine(x, y);
		} else {
			int degree = boxesSystem.degreeOfNormalLine(x, y, lastX, lastY);
			if (degree >= 0) {
				return degree;
			} else {
				return -1;
			}
		}
	}
	
	private void endTurn() {
		if (balls.size() == 0 && isShoot == true) {
			boxesSystem.dropBox();
			boxesSystem.randomGenerateBoxes();
			gun.setStop(false);
			isShoot = false;
		}
	}

	public void update(float delta) {
		gun.update(delta);
		removeOutBall();
		updateBalls(delta);
		endTurn();
		boxesSystem.clearZeroBox();
	}

}
