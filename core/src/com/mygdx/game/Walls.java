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
	
	public boolean isHitWall(int x, int y) {
		if (x <= 40 || x >= width - 40 || y >= height - 40) {
			return true;
		}
		return false;
	}
	
	public int degreeOfNormalLine(int x, int y) {
		if (x > 40 && x < width - 40) {
			if (y >= height - 40) {
				return 180;
			} 
			else {
				return 0;
			}
		} else {
			if (x >= width - 40) {
				return 90;
			} else {
				return 270;
			}
		}
	}
}
