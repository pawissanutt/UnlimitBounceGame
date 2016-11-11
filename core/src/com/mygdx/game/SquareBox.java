package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

public class SquareBox {

	private int x;
	private int y;
	private int durability;

	public static final int width = 60;
	public static final int height = 60;

	public SquareBox(int x, int y, int durability) {
		this.x = x;
		this.y = y;
		this.durability = durability;
	}

	public void drop() {
		y -= height;
	}

	Vector2 getPosition() {
		return new Vector2(x, y);
	}

	public boolean hasBoxAt(int x, int y) {
		if (x >= this.x && x <= this.x + width && y >= this.y && y <= this.y + height) {
			return true;
		}
		return false;
	}

	public void decreseDurability(int damage) {
		durability -= damage;
	}

	public int getDurability() {
		return durability;
	}
	
	private static float degreeMod(float degree) {
		if (degree < 0) {
			return (degree+3600)%360;
		}
		return degree%360;
	}

	private boolean checkHitLeftDirection(float x, float y, float direction) {
		direction = degreeMod(direction);
		if (direction > 180 && direction < 360 ) {
			direction -= 90;
			double radian = Math.toRadians(direction);
			double slope = Math.tan(radian);
			double yIntersect = slope * (this.x - x) + y;
			if (yIntersect > this. y && yIntersect < this.y + height) {
				return true;
			}
		}
		return false;
	}

	private boolean checkHitRightDirection(float x, float y, float direction) {
		direction = degreeMod(direction);
		if (direction > 0 && direction < 180) {
			direction -= 90;
			double radian = Math.toRadians(direction);
			double slope = Math.tan(radian);
			double yIntersect = slope * (this.x + width - x) + y;
			if (yIntersect > this.y && yIntersect < this.y + height) {
				return true;
			}
		}
		return false;
	}

	private boolean checkHitTopDirection(float x, float y, float direction) {
		direction = degreeMod(direction);
		if (direction > 90 && direction < 270) {
			direction -= 90;
			double radian = Math.toRadians(direction);
			double slope = Math.tan(radian);
			double xIntersect = (this.y + height - y) / slope + x;
			if (xIntersect > this.x && xIntersect < this.x + width) {
				return true;
			}
			if (direction == 270) {
				System.out.println("top"+ direction);
				return true;
			}
		}
		return false;
	}

	private boolean checkHitBottomDirection(float x, float y, float direction) {
		direction = degreeMod(direction);
		if (direction < 90 || direction > 270) {
			direction -= 90;
			double radian = Math.toRadians(direction);
			double slope = Math.tan(radian);
			double xIntersect = (this.y - y) / slope + x;
			if (xIntersect > x && xIntersect < x + width) {
				return true;
				
			}
			if (direction == 90) {
				System.out.println("bottom"+ direction);
				return true;
			}
		}
		return false;
	}
	
	public int degreeOfNormalLine (float x, float y, float direction) {
		if (checkHitLeftDirection(x, y, direction)) {
			return 90;
		}
		if (checkHitRightDirection(x, y, direction)) {
			return 270;
		}
		if (checkHitTopDirection(x, y, direction)) {
			return 0;
		}
		if (checkHitBottomDirection(x, y, direction)) {
			return 180;
		}
		return -1;
	}
}
