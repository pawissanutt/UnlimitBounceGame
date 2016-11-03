package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class WorldRenderer {

	private BallsRenderer ballsRenderer;
	private WallsRenderer wallsRenderer;
	private BoxesRenderer boxesRenderer;
	private SpriteBatch batch;
	private World world;
	private TextureRegion gunTexture;
	private Gun gun;
	
	public WorldRenderer (UnlimitBounceGame game, World world) {
		this.batch = game.batch;
		this.world = world;
		gunTexture = new TextureRegion(new Texture("gun.png"));
		gun = world.getGun();
		ballsRenderer = new BallsRenderer(game, world);
		wallsRenderer = new WallsRenderer(game, world);
		boxesRenderer = new BoxesRenderer(game, world);
	}
	
	public void render(float delta) { 
		ballsRenderer.render();
		wallsRenderer.render();
		boxesRenderer.render();
        Vector2 pos = gun.getPosition();
        batch.begin();
        batch.draw(gunTexture, pos.x,pos.y, gun.originX, gun.originY, gun.width, gun.height, gun.Scale, gun.Scale, gun.getRotation());
        //font.draw(batch, "" + world.getScore(), 700, 60);
        batch.end();
	}
}
	