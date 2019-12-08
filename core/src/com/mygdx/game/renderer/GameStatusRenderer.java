package com.mygdx.game.renderer;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.UnlimitBounceGame;
import com.mygdx.game.world.Ball;
import com.mygdx.game.world.World;

public class GameStatusRenderer {

	private SpriteBatch batch;
	private BitmapFont font;
	private Texture ballImg;
	private World world;
	private int x;
	private int y;
	
	private final int scoreWidth = 200;
	
	public GameStatusRenderer(UnlimitBounceGame game, World world, int x, int y) {
		this.batch = game.getBatch();
		this.world = world;
		this.x = x;
		this.y = y;
		ballImg = new Texture("ball.png");
		font = new BitmapFont();
	}
	
	public void render() {
		int cursorX = x;
		batch.begin();
		font.draw(batch, "Score: "+world.getScore(), cursorX, y);
		cursorX += scoreWidth;
		batch.draw(ballImg, cursorX - (Ball.width / 2), y - (Ball.height / 2));
		cursorX += Ball.width+1;
		font.draw(batch, " x "+world.getGun().getMaxBalls() , cursorX, y);
		batch.end();
	}
}
