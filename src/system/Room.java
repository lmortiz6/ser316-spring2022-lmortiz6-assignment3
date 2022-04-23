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
	
	public void addObject(GameObject obj, int x, int y) {
		interior.addObj(obj, x, y);
	}
	
	public GameObject getObject(int x, int y) {
		return interior.get(x, y);
	}
	
	public GameObject[][] getObjectGrid() {
		return interior.getAll();
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
			width = ROOM_WIDTH - 1;
			height = ROOM_HEIGHT - 1;
			objects = new GameObject[width][height];
			
			for (int i = 0; i < width; i++) {
				for (int j = 0; j < height; j++) {
					objects[i][j] = new Empty((int)position.getX() * Room.ROOM_WIDTH + i, (int)position.getY() * Room.ROOM_HEIGHT + j);
				}
			}
		}
		
		public void addObj(GameObject obj, int x, int y) {
			objects[x][y] = obj;
		}
		
		public GameObject get(int x, int y) {
			return objects[x][y];
		}
		public GameObject[][] getAll() {
			return objects;
		}
	}
}