package main.java.system;

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
	private Point absPos;
	private ROOM_TYPE type;
	
	public Room(int x, int y, ROOM_TYPE roomtype) {
		position = new Point(x, y);
		absPos = new Point((int)position.x * ROOM_WIDTH, (int)position.y * ROOM_HEIGHT);
		type = roomtype;
	}
	
	public ROOM_TYPE getType() {
		return type;
	}
	
	public Point getPosition() {
		return position;
	}
	
	public Point getPositionAbs() {
		return absPos;
	}
	
	public boolean isWithin(int x, int y) {
		return (x >= absPos.x && x <= absPos.x + ROOM_WIDTH && y >= absPos.y && y <= absPos.y + ROOM_HEIGHT);
	}
	
	/*private class Interior {
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
	}*/
}