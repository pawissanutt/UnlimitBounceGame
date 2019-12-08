package com.mygdx.game.renderer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.UnlimitBounceGame;
import com.mygdx.game.world.Gun;
import com.mygdx.game.world.World;

public class WorldRenderer {

	private BallsRenderer ballsRenderer;
	private WallsRenderer wallsRenderer;
	private BoxesRenderer boxesRenderer;
	private LineRenderer lineRenderer;
	private GameStatusRenderer gameStatusRenderer;
	private SpriteBatch batch;
	private World world;
	private TextureRegion gunTexture;
	private Gun gun;
	
	public WorldRenderer (UnlimitBounceGame game, World world) {
		this.batch = game.getBatch();
		this.world = world;
		gunTexture = new TextureRegion(new Texture("gun.png"));
		gun = world.getGun();
		ballsRenderer = new BallsRenderer(game, world);
		wallsRenderer = new WallsRenderer(game, world);
		boxesRenderer = new BoxesRenderer(game, world);
		lineRenderer = new LineRenderer(game, world);
		gameStatusRenderer = new GameStatusRenderer(game, world, UnlimitBounceGame.WIDTH/2, UnlimitBounceGame.HEIGHT - 20);
	}
	
	private void shouldChangeLengthOfLine() {
		if (Gdx.input.isKeyPressed(Keys.Q) && Gdx.input.isKeyPressed(Keys.W) && Gdx.input.isKeyJustPressed(Keys.E)) {
			lineRenderer.toggleLength();
		}
	}
	
	private void shouldRenderLine() {
		if (!world.inBounceInterval()) {
			lineRenderer.render();
		}
	}
	
	public void render(float delta) { 
		ballsRenderer.render();
		wallsRenderer.render();
		boxesRenderer.render();
		shouldRenderLine();
		shouldChangeLengthOfLine();
		gameStatusRenderer.render();
        Vector2 pos = gun.getPosition();
        batch.begin();
        batch.draw(gunTexture, pos.x,pos.y, gun.originX, gun.originY, gun.width, gun.height, gun.Scale, gun.Scale, gun.getRotation());
		// font.draw(batch, "" + world.getScore(), 700, 60);
        batch.end();
	}
}
