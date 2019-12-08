package com.mygdx.game.renderer;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.UnlimitBounceGame;
import com.mygdx.game.world.World;

public class LineRenderer {
	
	private float x;
	private float y;
	private float rotation;
	private World world;
	private SpriteBatch batch;
	private Texture lineImg;
	private int length;
	
	private static final int normalLength = 50;
	private static final int cheatLength = 1000;
	private static final int width = 6;
	private static final int speed = 15;
	
	public  LineRenderer (UnlimitBounceGame game, World world) {
		this.batch = game.getBatch();
		this.world = world;
		length = normalLength;
		lineImg = new Texture("line.png");
	}
	
	public void toggleLength() {
		if (length == normalLength) {
			length = cheatLength;
		} else {
			length = normalLength;
		}
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
		float newX = (float) (x - speed * Math.sin(radian));
		float newY = (float) (y + speed * Math.cos(radian));
		int degreeOfNormalLine = world.degreeOfNormalLineThatBallhit(newX, newY,  x,  y, rotation, 0);
		if (degreeOfNormalLine >= 0) {
			rotation = 2 * degreeOfNormalLine + 180 - rotation;
		}
	}
}
