package com.mygdx.game.renderer;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.UnlimitBounceGame;
import com.mygdx.game.world.Ball;
import com.mygdx.game.world.World;

public class BallsRenderer {

	private SpriteBatch batch;
	private ArrayList<Ball> balls;
	private TextureRegion ballImg;

	public BallsRenderer(UnlimitBounceGame game, World world) {
		this.batch = game.getBatch();
		balls = world.getBalls();
		ballImg = new TextureRegion(new Texture("ball.png"));
	}

	public void render() {
		for (int i = 0; i < balls.size(); i++) {
			Ball ball = balls.get(i);
			batch.begin();
			batch.draw(ballImg, ball.getPosition().x - (ball.width / 2), ball.getPosition().y - (ball.height / 2),
					ball.originX, ball.originY, ball.width, ball.height, ball.Scale, ball.Scale, 0);
			batch.end();
		}
	}
}
