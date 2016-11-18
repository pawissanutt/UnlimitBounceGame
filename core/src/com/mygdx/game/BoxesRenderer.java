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
		boxImg = new Texture("Box.png");
		boxes = boxesSystem.getBoxes();
		font = new BitmapFont();
	}

	public void render() {
		for (int i = 0; i < boxes.size(); i++) {
			SquareBox box = boxes.get(i);
			batch.begin();
			batch.draw(boxImg, box.getPosition().x, box.getPosition().y, box.width, box.height);
		    String numberAsString = String.valueOf(box.getDurability());
		    String dura = "   ".substring(numberAsString.length()) + numberAsString;
			font.draw(batch, dura, (int) box.getPosition().x + 17, (int) box.getPosition().y + 35);
			batch.end();
		}
	}
}
