package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class WallsRenderer {

	private SpriteBatch batch;
	private Texture wallImg;
	private Walls walls;
	
	public WallsRenderer (UnlimitBounceGame game, World world) {
		this.batch = game.batch;
		walls = world.getWalls();
		wallImg = new Texture("wall.png");
	}
	
	private void renderLeft() {
		for (int y = 0; y < walls.height; y += 40) {
			batch.begin();
			batch.draw(wallImg, 0, y);
			batch.end();
		}
	}
	
	private void renderRight() {
		for (int y = 0; y < walls.height; y += 40) {
			batch.begin();
			batch.draw(wallImg, walls.width-40, y);
			batch.end();
		}
	}
	
	private void renderTop() {
		for (int x = 0; x < walls.width; x += 40) {
			batch.begin();
			batch.draw(wallImg, x, walls.height - 40);
			batch.end();
		}
	}
	
	private void renderBottom() {
		for (int x = 0; x < walls.width; x += 40) {
			batch.begin();
			batch.draw(wallImg, x, 0);
			batch.end();
		}
	}
	
	public void render() {
		renderLeft();
		renderRight();
		renderTop();
		renderBottom();
	}
}
