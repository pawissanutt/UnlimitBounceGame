package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

public class Ball {

	private float x;
	private float y;
	private float rotation;
	private World world;
	
	public static final int damage = 1;
	public static final int width = 15;
	public static final int height = 15;
	public static final int Scale = 1;
	public static final int originX = 7;
	public static final int originY = 7;
	public static final int speed = 15;
	public static final int gameWidth = UnlimitBounceGame.WIDTH;
	public static final int gameHeight = UnlimitBounceGame.HEIGHT;

	public Ball(int x, int y, float rotation, World world) {
		this.x = x;
		this.y = y;
		this.rotation = rotation;
		this.world = world;
	}

	private void changeRotation() {
		rotation = rotation % 360;
		double radian = Math.toRadians(rotation);
		float newX = (float) (x - speed * Math.sin(radian));
		float newY = (float) (y + speed * Math.cos(radian));
		int degreeOfNormalLine = world.degreeOfNormalLineThatBallhit(newX, newY, x, y, rotation, damage);
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
