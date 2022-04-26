package main.java.system;

import java.awt.Point;
import java.util.ArrayList;

public class Hitbox {
	private int width, length;
	
	public Hitbox(int w, int l) {
		width = w;
		length = l;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getLength() {
		return length;
	}
	
	public ArrayList<Point> getPositions(Point origin, String direction) {
		switch (direction.toUpperCase()) {
		case "NORTH":
			return getNorth(origin);
		case "EAST":
			return getEast(origin);
		case "SOUTH":
			return getSouth(origin);
		default:
			return getWest(origin);
		}
	}
	
	public ArrayList<Point> getNorth(Point origin) {
		ArrayList<Point> pos = new ArrayList<Point>();
		int targetX = origin.x - (width / 2);
		int targetY = origin.y - 1;
		
		for (int i = 0; i < width; i++) {
			for (int j = 0; j > -length; j--) {
				pos.add(new Point(targetX + i, targetY + j));
			}
		}
		return pos;
	}
	
	public ArrayList<Point> getEast(Point origin) {
		ArrayList<Point> pos = new ArrayList<Point>();
		int targetX = origin.x + 1;
		int targetY = origin.y - (width / 2);
		
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < length; j++) {
				pos.add(new Point(targetX + j, targetY + i));
			}
		}
		return pos;
	}
	
	public ArrayList<Point> getSouth(Point origin) {
		ArrayList<Point> pos = new ArrayList<Point>();
		int targetX = origin.x - (width / 2);
		int targetY = origin.y + 1;
		
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < length; j++) {
				pos.add(new Point(targetX + i, targetY + j));
			}
		}
		return pos;
		
	}
	
	public ArrayList<Point> getWest(Point origin) {
		ArrayList<Point> pos = new ArrayList<Point>();
		int targetX = origin.x - 1;
		int targetY = origin.y - (width / 2);
		
		for (int i = 0; i < width; i++) {
			for (int j = 0; j > -length; j--) {
				pos.add(new Point(targetX + j, targetY + i));
			}
		}
		return pos;
	}

}
