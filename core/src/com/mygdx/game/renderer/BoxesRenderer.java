package com.mygdx.game.renderer;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.UnlimitBounceGame;
import com.mygdx.game.world.BoxesSystem;
import com.mygdx.game.world.SquareBox;
import com.mygdx.game.world.World;

public class BoxesRenderer {

	private SpriteBatch batch;
	private BoxesSystem boxesSystem;
	private ArrayList<SquareBox> boxes;
	private Texture boxImg;
	private BitmapFont font;

	public BoxesRenderer(UnlimitBounceGame game, World world) {
		this.batch = game.getBatch();
		boxesSystem = world.getBoxSystem();
		boxImg = new Texture("box.png");
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
