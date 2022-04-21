package system;

import java.awt.Point;

public class Room {
	public final static int ROOM_WIDTH = 10;
	public final static int ROOM_HEIGHT = 8;
	
	public static enum ROOM_TYPE {
		START,
		NORMAL,
		TREASURE,
		SHOP,
		END,
		NULL
	}
	
	private Point position;
	private ROOM_TYPE type;
	private Interior interior;
	
	public Room(int x, int y, ROOM_TYPE roomtype) {
		position = new Point(x, y);
		type = roomtype;
		interior = new Interior();
	}
	
	public GameObject getObject(int x, int y) {
		return interior.get(x, y);
	}
	
	public ROOM_TYPE getType() {
		return type;
	}
	
	public Point getPosition() {
		return position;
	}
	
	private class Interior {
		private int width;
		private int height;
		private GameObject[][] objects;
		
		public Interior() {
			width = ROOM_WIDTH - 2;
			height = ROOM_HEIGHT -2;
			objects = new GameObject[width][height];
			
			for (int i = 0; i < width; i++) {
				for (int j = 0; j < height; j++) {
					objects[i][j] = new Empty((int)position.getX() + i, (int)position.getY() + j);
				}
			}
		}
		
		public GameObject get(int x, int y) {
			return objects[x][y];
		}
	}
}