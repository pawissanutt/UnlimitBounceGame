package com.mygdx.game;

import java.util.ArrayList;
import java.util.Collections;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameOverScreen {
	private SpriteBatch batch;
	private Texture titleImg;
	private BitmapFont font;
	private ArrayList<Integer> highScore;
	
	public GameOverScreen(UnlimitBounceGame game) {
		this.batch = game.batch;
		titleImg = new Texture("title2.png");
		font = new BitmapFont();
		highScore = new ArrayList<Integer>();
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
		font.getData().setScale(2);
		font.draw(batch, "Game Over", 220, 500);
		renderHighScore();
		batch.end();
	}
	
	public void addHighScore(int score) {
		highScore.add(score);
		sortHighScore();
	}
	
	private void sortHighScore() {
		Collections.sort(highScore);
	    Collections.reverse(highScore);
	}
	
	private void renderHighScore() {
		font.draw(batch, "HighScore:", 220, 400);
		for (int i = 0; i < highScore.size(); i++) {
			font.draw(batch, (i+1)+") : "+highScore.get(i) , 200, 360 - i * 30);
			if (i == 4) {
				break;
			}
		}
	}
}
