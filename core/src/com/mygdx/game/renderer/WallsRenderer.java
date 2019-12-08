package com.mygdx.game.renderer;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.UnlimitBounceGame;
import com.mygdx.game.world.Walls;
import com.mygdx.game.world.World;

public class WallsRenderer {

	private SpriteBatch batch;
	private Texture wallImg;
	private Walls walls;
	
	public WallsRenderer (UnlimitBounceGame game, World world) {
		this.batch = game.getBatch();
		walls = world.getWalls();
		wallImg = new Texture("wall.png");
	}
	
	private void renderLeft() {
		for (int y = 0; y < walls.height; y += Walls.wallWidth) {
			batch.begin();
			batch.draw(wallImg, 0, y, Walls.wallWidth, Walls.wallWidth);
			batch.end();
		}
	}
	
	private void renderRight() {
		for (int y = 0; y < walls.height; y += Walls.wallWidth) {
			batch.begin();
			batch.draw(wallImg, walls.width-Walls.wallWidth, y, Walls.wallWidth, Walls.wallWidth);
			batch.end();
		}
	}
	
	private void renderTop() {
		for (int x = 0; x < walls.width; x += Walls.wallWidth) {
			batch.begin();
			batch.draw(wallImg, x, walls.height - Walls.wallWidth, Walls.wallWidth, Walls.wallWidth);
			batch.end();
		}
	}
	
	private void renderBottom() {
		for (int x = 0; x < walls.width; x += Walls.wallWidth) {
			batch.begin();
			batch.draw(wallImg, x, 0, Walls.wallWidth, Walls.wallWidth);
			batch.end();
		}
	}
	
	public void render() {
		renderLeft();
		renderRight();
		renderTop();
//		renderBottom();
	}
}
