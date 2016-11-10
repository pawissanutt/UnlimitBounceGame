package com.mygdx.game;

public class Walls {
	
	public static int width;
	public static int height;
	
	public static final int  wallWidth = 60;
	
	public Walls () {
		width = UnlimitBounceGame.WIDTH;
		width = width - (width % wallWidth);
		height = UnlimitBounceGame.HEIGHT;
		height = height - (height % wallWidth) - wallWidth;	
	}
	
	public boolean isHitWall(int x, int y) {
		if (x <= wallWidth || x >= width - wallWidth || y >= height - wallWidth) {
			return true;
		}
		return false;
	}
	
	public int degreeOfNormalLine(int x, int y) {
		if (x > wallWidth && x < width - wallWidth) {
			if (y >= height - wallWidth) {
				return 180;
			} 
			else {
				return 0;
			}
		} else {
			if (x >= width - wallWidth) {
				return 90;
			} else {
				return 270;
			}
		}
	}
}
