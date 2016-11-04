package com.mygdx.game;

import java.awt.Font;
import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class BoxesRenderer {

	private SpriteBatch batch;
	private BoxesSystem boxesSystem;
	private ArrayList<SquareBox> boxes;
	private Texture boxImg;
	private BitmapFont font;

	public BoxesRenderer(UnlimitBounceGame game, World world) {
		this.batch = game.batch;
		boxesSystem = world.getBoxSystem();
		boxImg = new Texture("box.png");
		boxes = boxesSystem.getBoxes();
		font = new BitmapFont();
	}

	public void render() {
		for (int i = 0; i < boxes.size(); i++) {
			SquareBox box = boxes.get(i);
			batch.begin();
			batch.draw(boxImg, box.getPosition().x, box.getPosition().y);
			String dura = "";
			if (box.getDurability() <= 9) {
				dura += " ";
			}
			dura += box.getDurability();
			font.draw(batch, dura, (int) box.getPosition().x + 10, (int) box.getPosition().y + 25);
			batch.end();
		}
	}
}
