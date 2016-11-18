package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;

public class GameScreen extends ScreenAdapter {

	public enum ScreenStatus {
		start, play, end
	};

	private ScreenStatus status;
	private UnlimitBounceGame game;
	private World world;
	private WorldRenderer worldRenderer;
	private StartScreen startScreen;
	private GameOverScreen gameOverScreen;
	private SoundTrack sound;

	public GameScreen(UnlimitBounceGame game) {
		this.game = game;
		world = new World();
		worldRenderer = new WorldRenderer(game, world);
		startScreen = new StartScreen(game);
		gameOverScreen = new GameOverScreen(game);
		status = ScreenStatus.start;
		sound = new SoundTrack();
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		update(delta);
	}
	
	private void shouldChangeToPlayScreen() {
		if (Gdx.input.isKeyPressed(Keys.ENTER)) {
			status = ScreenStatus.play;
			world = new World();
			worldRenderer = new WorldRenderer(game, world);
		}
	}
	
	private void shouldChangeToGameOverScreen() {
		if (world.getBoxSystem().checkGameOver()){
			status = ScreenStatus.end;
			gameOverScreen.addHighScore(world.getScore());
		}
	}

	private void update(float delta) {
		if (status == ScreenStatus.start) {
			startScreen.render();
			shouldChangeToPlayScreen();
		} else if (status == ScreenStatus.play) {
			world.update(delta);
			world.skip(delta);
			worldRenderer.render(delta);
			shouldChangeToGameOverScreen();
		} else if (status == ScreenStatus.end) {
			gameOverScreen.render();
			shouldChangeToPlayScreen();
		}
	}
}
