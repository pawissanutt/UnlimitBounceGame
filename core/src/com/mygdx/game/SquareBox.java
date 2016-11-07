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

	public int degreeOfNormalLine(int newX, int newY, int lastX, int lastY) {
		if (lastX <= this.x) {
			if (lastY < this.y) {
				if (this.x - newX < this.y - newY) {
					return 90;
				} else {
					return 180;
				}
			} else if (lastY > this.y + height) {
				if (this.x - newX < newY - (this.y + height)) {
					return 90;
				} else {
					return 0;
				}
			} else {
				return 90;
			}
		}
		if (lastX >= this.x + width) {
			if (lastY < this.y) {
				if (newX - (this.x + width) < this.y - newY) {
					return 270;
				} else {
					return 180;
				}
			} else if (lastY > this.y + height) {
				if (newX - (this.x + width) < newY - (this.y + height)) {
					return 270;
				} else {
					return 0;
				}
			} else {
				return 270;
			}
		}
		if (lastY <= this.y) {
			if (lastX < this.x) {
				if (this.y - newY < this.x - newX) {
					return 180;
				} else {
					return 90;
				}
			} else if (lastX > this.x + width) {
				if (this.y - newY < newX - (this.x + width)) {
					return 180;
				} else {
					return 270;
				}
			} else {
				return 180;
			}
		}
		if (lastY >= this.y + height) {
			if (lastX < this.x) {
				if (newY - (this.y + height) < this.x - newX) {
					return 0;
				} else {
					return 90;
				}
			} else if (lastX > this.x + width) {
				if (newY - (this.y + height) < newX - (this.x + width)) {
					return 0;
				} else {
					return 270;
				}
			} else {
				return 0;
			}
		}
		return -1;
	}
}
