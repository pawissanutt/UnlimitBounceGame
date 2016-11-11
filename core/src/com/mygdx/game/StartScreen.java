package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class StartScreen {
	
	private SpriteBatch batch;
	private Texture titleImg;
	private BitmapFont font;
	
	public StartScreen(UnlimitBounceGame game) {
		this.batch = game.batch;
		titleImg = new Texture("title2.png");
		font = new BitmapFont();
	}
	
	public boolean toPlayScreen() {
		if (Gdx.input.isKeyPressed(Keys.ENTER)) {
			return true;
		}
		return false;
	}
	
	public void render() {
		batch.begin();
		batch.draw(titleImg, 100, 600);
		batch.end();
	}
	
}
