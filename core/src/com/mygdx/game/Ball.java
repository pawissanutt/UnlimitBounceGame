package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

public class Ball {
	
	private int x;
	private int y;
	private int rotation;
	private World world;
	
	final int width = 15;
	final int height = 15;
	final int Scale = 1;
	final int originX = 7;
	final int originY = 7;
	final int Speed = 10;
	final int gameWidth = UnlimitBounceGame.WIDTH;
	final int gameHeight = UnlimitBounceGame.HEIGHT;

	public Ball(int x, int y, int rotation, World world) { 
		this.x = x;
		this.y = y;
		this.rotation = rotation;
		this.world = world;
		System.out.println(" new ball "+ this.rotation);
	}
	
	private void changeRotation() {
		rotation = rotation % 360;
		double radian = Math.toRadians(rotation);
		int newX = (int) (x - Speed*Math.sin(radian));
		int newY = (int) (y + Speed*Math.cos(radian));
		int degreeOfNormalLine = world.degreeOfNormalLineThatBallhit(newX, newY);
		System.out.println(degreeOfNormalLine);
		if (degreeOfNormalLine >= 0)
		{
			rotation = 2 * degreeOfNormalLine + 180 - rotation;
			
		}
	}
	
	Vector2 getPosition() {
		return new Vector2(x,y);	
	}
	
	public void update (float delta) {
		double radian = Math.toRadians(rotation);
		x -= Speed*Math.sin(radian);
		y += Speed*Math.cos(radian);
		changeRotation();
	}
	
	public boolean shouldRemoveBall() {
		if (x < 0 || x > gameWidth || y < 0 || y > gameHeight) {
			return true;
		}
		return false;
	}
}
