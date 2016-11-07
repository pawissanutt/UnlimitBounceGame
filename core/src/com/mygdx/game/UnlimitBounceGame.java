package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class UnlimitBounceGame extends Game {
	SpriteBatch batch;
	public static final int HEIGHT = 900;
	public static final int WIDTH = 600;

	@Override
	public void create() {
		batch = new SpriteBatch();
		setScreen(new GameScreen(this));
	}

	@Override
	public void render() {
		super.render();
	}

	@Override
	public void dispose() {
		batch.dispose();
	}
}
