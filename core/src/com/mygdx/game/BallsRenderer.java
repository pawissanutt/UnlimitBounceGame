package com.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class BallsRenderer {
	
	private SpriteBatch batch;
	private ArrayList<Ball> balls ;
	private TextureRegion ballImg;
	
	public BallsRenderer (UnlimitBounceGame game, World world) {
		this.batch = game.batch;
		balls = world.getBalls();
		ballImg = new TextureRegion( new Texture("ball.png"));
	}
	
	public void render () {
		for (int i = 0; i < balls.size(); i++) {
			Ball ball = balls.get(i);
			batch.begin();
			batch.draw(ballImg, ball.getPosition().x, ball.getPosition().y, ball.originX, ball.originY, ball.width, ball.height, ball.Scale, ball.Scale, 0);
			batch.end();
		}
	}
}