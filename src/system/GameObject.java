package system;

import java.awt.Point;

public class GameObject {
	protected Point position;
	protected char ascii;

	public GameObject(int x, int y) {
		position = new Point(x, y);
		ascii = '·';
	}
	
	public char getAscii() {
		return ascii;
	}
	
	public Point getPosition() {
		return position;
	}
}
