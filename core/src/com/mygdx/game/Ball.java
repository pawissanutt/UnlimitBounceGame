package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

public class Ball {

	private float x;
	private float y;
	private int rotation;
	private World world;
	
	public static final int damage = 1;

	final int width = 15;
	final int height = 15;
	final int Scale = 1;
	final int originX = 7;
	final int originY = 7;
	final int speed = 15;
	final int gameWidth = UnlimitBounceGame.WIDTH;
	final int gameHeight = UnlimitBounceGame.HEIGHT;

	public Ball(int x, int y, int rotation, World world) {
		this.x = x;
		this.y = y;
		this.rotation = rotation;
		this.world = world;
	}

	private void changeRotation() {
		rotation = rotation % 360;
		double radian = Math.toRadians(rotation);
		int newX = (int) (x - speed * Math.sin(radian));
		int newY = (int) (y + speed * Math.cos(radian));
		int degreeOfNormalLine = world.degreeOfNormalLineThatBallhit(newX, newY, (int) x, (int) y);
		if (degreeOfNormalLine >= 0) {
			rotation = 2 * degreeOfNormalLine + 180 - rotation;
		}
	}

	Vector2 getPosition() {
		return new Vector2(x, y);
	}

	public void update(float delta) {
		double radian = Math.toRadians(rotation);
		x -= speed * Math.sin(radian);
		y += speed * Math.cos(radian);
		changeRotation();
	}

	public boolean shouldRemoveBall() {
		if (x < 0 || x > gameWidth || y < 0 || y > gameHeight) {
			return true;
		}
		return false;
	}
}
