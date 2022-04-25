package main.java.object;

import java.awt.Point;

import main.java.system.Floor;

public class GameObject {
	protected Point position;
	protected char ascii;
	protected Floor floor;

	public GameObject(int x, int y, Floor floor) {
		position = new Point(x, y);
		ascii = '·';
		this.floor = floor;
	}
	
	public char getAscii() {
		return ascii;
	}
	
	public Point getPosition() {
		return position;
	}
	
	public void setPosition(int x, int y) {
		position = new Point(x, y);
	}
	
	public void setFloor(Floor floor) {
		this.floor = floor;
	}
}
