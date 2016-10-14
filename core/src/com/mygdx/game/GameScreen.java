package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;

public class GameScreen extends ScreenAdapter{

	 @Override
	    public void render(float delta) {
	    	update( delta);
	    //	world.update(delta);
	    	Gdx.gl.glClearColor(0, 0, 0, 1);
	        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

	    //  worldRenderer.render(delta);
	    }
	    
	    private void update(float delta) {
//	        updatePacmanDirection();
//	        world.update(delta);
	    }
}
