package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class LineRenderer {
	
	private float x;
	private float y;
	private float rotation;
	private World world;
	private SpriteBatch batch;
	private Texture lineImg;
	
	private static final int width = 10;
	private static final int length = 1000;
	private static final int speed = 15;
	
	public  LineRenderer (UnlimitBounceGame game, World world) {
		this.batch = game.batch;
		this.world = world;
		lineImg = new Texture("line.png");
	}
	
	public void render() {
		x = world.getGun().getShootPosition().x;
		y = world.getGun().getShootPosition().y;
		rotation = world.getGun().getRotation();
		batch.begin();
		for (int i = 0; i < length; i++){
			double radian = Math.toRadians(rotation);
			x -= speed * Math.sin(radian);
			y += speed * Math.cos(radian);
			changeRotation();
			batch.draw(lineImg, x - width/2, y - width/2, width, width);
		}
		batch.end();
	}
	
	private void changeRotation() {
		rotation = rotation % 360;
		double radian = Math.toRadians(rotation);
		int newX = (int) (x - speed * Math.sin(radian));
		int newY = (int) (y + speed * Math.cos(radian));
		int degreeOfNormalLine = world.degreeOfNormalLineThatLinehit(newX, newY, (int) x, (int) y);
		if (degreeOfNormalLine >= 0) {
			rotation = 2 * degreeOfNormalLine + 180 - rotation;
		}
	}
}