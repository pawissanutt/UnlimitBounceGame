package com.mygdx.game;

import java.util.ArrayList;

public class BoxesSystem {

	private double generateBoxChance;
	private double maxDurabilityBox;
	private ArrayList<SquareBox> boxes;

	public BoxesSystem() {
		boxes = new ArrayList<SquareBox>();
		addBox(120, 400, 99);
		generateBoxChance = 0.5;
		maxDurabilityBox = 20;
		randomGenerateBoxes();
	}

	public int getNumberofBoxes() {
		return boxes.size();
	}

	public ArrayList<SquareBox> getBoxes() {
		return boxes;
	}

	private void addBox(int x, int y, int durability) {
		boxes.add(new SquareBox(x, y, durability));
	}

	private void removeBox(int index) {
		boxes.remove(index);
	}

	private int getIndex(int x, int y) {
		int index = 0;
		for (index = 0; index < boxes.size(); index++) {
			if (boxes.get(index).hasBoxAt(x, y))
				return index;
		}
		return -1;
	}

	public void clearZeroBox() {
		for (int i = 0; i < boxes.size(); i++) {
			if (boxes.get(i).getDurability() <= 0) {
				boxes.remove(i);
				break;
			}
		}
	}

	public int degreeOfNormalLine(int newX, int newY, int lastX, int lastY) {
		int index = getIndex(newX, newY);
		if (index >= 0) {
			boxes.get(index).decreseDurability();
			return boxes.get(index).degreeOfNormalLine(newX, newY, lastX, lastY);
		} else {
			return -1;
		}
	}

	public void dropBox() {
		for (int i = 0; i < boxes.size(); i++) {
			boxes.get(i).drop();
		}
	}

	public void randomGenerateBoxes() {
		int y = UnlimitBounceGame.WIDTH - 2 * SquareBox.height;
		for (int x = 40; x < UnlimitBounceGame.WIDTH - SquareBox.width; x += SquareBox.width) {
			double random = Math.random();
			if (random <= generateBoxChance) {
				random = Math.random();
				addBox(x, y, (int) (random*maxDurabilityBox));
			}
		}
	}

}
