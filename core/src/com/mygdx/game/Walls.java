package com.mygdx.game;

public class Walls {
	
	public int width;
	public int height;
	
	public Walls () {
		width = UnlimitBounceGame.WIDTH;
		width = width - (width % 40);
		height = UnlimitBounceGame.HEIGHT;
		height = height - (height % 40);	
	}
}
