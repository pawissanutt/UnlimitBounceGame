package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.UnlimitBounceGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = UnlimitBounceGame.WIDTH;
        config.height = UnlimitBounceGame.HEIGHT;
		new LwjglApplication(new UnlimitBounceGame(), config);
	}
}
