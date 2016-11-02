package com.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;

public class World {
	
	private Gun gun;
	private ArrayList<Ball> balls ;
	private Walls walls;
	
	public World () {
		gun = new Gun();
		balls = new ArrayList<Ball>();
		walls = new Walls();
	}
	
	public ArrayList<Ball> getBalls () {
		return balls;
	}
	
	public Walls getWalls() {
		return this.walls;
	}
	
	public Gun getGun() {
		return this.gun;
	}
	
	private void makeBall(int x, int y, int rotation) {
		balls.add(new Ball(x, y, rotation));
	}
	
	private void shootBall() {
		if (Gdx.input.isKeyJustPressed(Keys.SPACE)) {
			Vector2 pos = gun.getShootPosition();
			makeBall((int)pos.x, (int)pos.y, gun.getRotation());
			System.out.println(" new ball");
		}
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
	
	public void update (float delta) {
		gun.update(delta);
		removeOutBall();
		updateBalls(delta);
		shootBall();
	}

}
