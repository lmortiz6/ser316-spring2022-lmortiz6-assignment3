package object;

import java.awt.Point;

import system.Floor;

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
}
