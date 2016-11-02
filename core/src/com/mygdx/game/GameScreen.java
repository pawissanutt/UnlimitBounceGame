package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;

public class GameScreen extends ScreenAdapter {

	private UnlimitBounceGame game;
	private World world;
	private WorldRenderer worldRenderer;

	public GameScreen(UnlimitBounceGame game) {
		this.game = game;
		world = new World();
		worldRenderer = new WorldRenderer(game, world);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		update(delta);
	}

	private void update(float delta) {
		world.update(delta);
		worldRenderer.render(delta);
	}
	
	private void updatePacmanDirection() {
    	Gun gun = world.getGun();
//        if(Gdx.input.isKeyPressed(Keys.UP)) {
//            
//        }
//        if(Gdx.input.isKeyPressed(Keys.DOWN)) {
//            
//        }
        if(Gdx.input.isKeyPressed(Keys.LEFT)) {
         
        }
        if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
        
        }
    	
    }
}
