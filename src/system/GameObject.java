package system;

import java.awt.Point;

public class GameObject {
	protected Point position;

	public GameObject(int x, int y) {
		position = new Point(x, y);
	}
}
