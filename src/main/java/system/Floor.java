package main.java.system;

import java.util.ArrayList;

import main.java.object.Empty;
import main.java.object.GameObject;
import main.java.object.Wall;
import main.java.object.Item;
import main.java.object.Entity;

public class Floor {
	
	public static int FLOOR_SIZE = 20;
	
	private Layout layout;
	ArrayList<GameObject> wallsList;
	ArrayList<GameObject> furnitureList;
	ArrayList<GameObject> itemsList;
	ArrayList<GameObject> entitiesList;
	private int compass, oldX, oldY, newX, newY;
	private int topRow, leftSide, bottom, rightSide;
	
	public Floor(Layout lout) {
		layout = lout;
		wallsList = new ArrayList<GameObject>();
		furnitureList = new ArrayList<GameObject>();
		itemsList = new ArrayList<GameObject>();
		entitiesList = new ArrayList<GameObject>();
		generateWalls();
		makeDoors();
		topRow = FLOOR_SIZE * Room.ROOM_HEIGHT;
		leftSide = FLOOR_SIZE * Room.ROOM_WIDTH;
		bottom = 0;
		rightSide = 0;
		setBounds();
	}
	
	public void setBounds() {
		for (GameObject obj : wallsList) {
			if (obj.getPosition().y < topRow) {
				topRow = obj.getPosition().y;
			}
			if (obj.getPosition().x < leftSide) {
				leftSide = obj.getPosition().x;
			}
			if (obj.getPosition().y > bottom) {
				bottom = obj.getPosition().y;
			}
			if (obj.getPosition().x > rightSide) {
				rightSide = obj.getPosition().x;
			}
		}
		topRow--;
		leftSide--;
		bottom++;
		rightSide++;
	}
	public int getTop() {
		return topRow;
	}
	public int getLeft() {
		return leftSide;
	}
	public int getBottom() {
		return bottom;
	}
	public int getRight() {
		return rightSide;
	}
	
	public void addObject(GameObject obj) {
		if (obj instanceof Wall) {
			furnitureList.add(obj);
		}
		else if (obj instanceof Item) {
			itemsList.add(obj);
		}
		else if (obj instanceof Entity) {
			entitiesList.add(obj);
		}
	}
	public void removeObject(GameObject obj) {
		if (obj instanceof Wall) {
			furnitureList.remove(obj);
		}
		else if (obj instanceof Item) {
			itemsList.remove(obj);
		}
		else if (obj instanceof Entity) {
			entitiesList.remove(obj);
		}
	}
	
	public GameObject getObject(int x, int y) {
		for (GameObject obj : entitiesList) {
			if ((int)obj.getPosition().x == x && (int)obj.getPosition().y == y)
				return obj;
		}
		for (GameObject obj : itemsList) {
			if ((int)obj.getPosition().x == x && (int)obj.getPosition().y == y)
				return obj;
		}
		for (GameObject obj : furnitureList) {
			if ((int)obj.getPosition().x == x && (int)obj.getPosition().y == y)
				return obj;
		}
		for (GameObject obj : wallsList) {
			if ((int)obj.getPosition().x == x && (int)obj.getPosition().y == y)
				return obj;
		}
		return null;
	}
	
	public void addWall(GameObject obj) {
		wallsList.add(obj);
	}
	public GameObject getWall(int x, int y) {
		for (GameObject obj : wallsList) {
			if ((int)obj.getPosition().x == x && (int)obj.getPosition().y == y)
				return obj;
		}
		return null;
	}
	public ArrayList<GameObject> getWalls() {
		return wallsList;
	}

	public void addFurniture(GameObject obj) {
		furnitureList.add(obj);
	}
	public void removeFurniture(GameObject obj) {
		furnitureList.remove(obj);
	}
	public ArrayList<GameObject> getFurnitureList() {
		return furnitureList;
	}
	
	public GameObject getFurniture(int x, int y) {
		for (GameObject obj : furnitureList) {
			if ((int)obj.getPosition().x == x && (int)obj.getPosition().y == y)
				return obj;
		}
		return null;
	}
	
	public void addItem(GameObject obj) {
		itemsList.add(obj);
	}
	public void removeItem(GameObject obj) {
		itemsList.remove(obj);
	}
	public ArrayList<GameObject> getItems() {
		return itemsList;
	}

	public GameObject getItem(int x, int y) {
		for (GameObject obj : itemsList) {
			if ((int)obj.getPosition().x == x && (int)obj.getPosition().y == y)
				return obj;
		}
		return null;
	}
	
	public void addEntity(GameObject obj) {
		entitiesList.add(obj);
	}
	public void removeEntity(GameObject obj) {
		entitiesList.remove(obj);
	}
	public ArrayList<GameObject> getEntities() {
		return entitiesList;
	}

	public GameObject getEntity(int x, int y) {
		for (GameObject obj : entitiesList) {
			if ((int)obj.getPosition().x == x && (int)obj.getPosition().y == y)
				return obj;
		}
		return null;
	}
	
	public Layout getLayout() {
		return layout;
	}
	
	private void generateWalls() {
		int targetX, targetY;
		
		for (Room room : layout.getRoomList()) {
			targetY = (int)room.getPosition().getY() * Room.ROOM_HEIGHT;
			for (int i = 0; i < Room.ROOM_WIDTH + 1; i++) {
				targetX = (int)room.getPosition().getX() * Room.ROOM_WIDTH + i;
				wallsList.add(new Wall(targetX, targetY, this));
			}
			for (int i = 0; i < Room.ROOM_HEIGHT - 1; i++) {
				targetX = (int)room.getPosition().getX() * Room.ROOM_WIDTH;
				targetY = (int)room.getPosition().getY() * Room.ROOM_HEIGHT + 1 + i;
				wallsList.add(new Wall(targetX, targetY, this));
				targetX += Room.ROOM_WIDTH;
				wallsList.add(new Wall(targetX, targetY, this));
			}
			targetY = (int)room.getPosition().getY() * Room.ROOM_HEIGHT + Room.ROOM_HEIGHT;
			for (int i = 0; i < Room.ROOM_WIDTH + 1; i++) {
				targetX = (int)room.getPosition().getX() * Room.ROOM_WIDTH + i;
				wallsList.add(new Wall(targetX, targetY, this));
			}
		}
	}
	
	private void makeDoors() {
		for (Room room : layout.getRoomList()) {
			compass = 0;
			oldX = room.getPosition().x;
			oldY = room.getPosition().y;
			int targetX, targetY;
			
			for (int i = 0; i < 4; i++) {
				followCompass();
				if (layout.getType(newX, newY) != Room.ROOM_TYPE.NULL) {
					switch (compass) {
					case 0: // NORTH
						targetX = (int)room.getPosition().x * Room.ROOM_WIDTH + (Room.ROOM_WIDTH / 2);
						targetY = (int)room.getPosition().y * Room.ROOM_HEIGHT;
						wallsList.remove(getWall(targetX, targetY));
						wallsList.add(new Empty(targetX, targetY, this));
						break;
					case 1: // EAST
						targetX = (int)room.getPosition().x * Room.ROOM_WIDTH + (Room.ROOM_WIDTH);
						targetY = (int)room.getPosition().y * Room.ROOM_HEIGHT + (Room.ROOM_HEIGHT / 2);
						wallsList.remove(getWall(targetX, targetY));
						wallsList.add(new Empty(targetX, targetY, this));
						break;
					case 2: // SOUTH
						targetX = (int)room.getPosition().x * Room.ROOM_WIDTH + (Room.ROOM_WIDTH / 2);
						targetY = (int)room.getPosition().y * Room.ROOM_HEIGHT + (Room.ROOM_HEIGHT);
						wallsList.remove(getWall(targetX, targetY));
						wallsList.add(new Empty(targetX, targetY, this));
						break;
					case 3: // WEST
						targetX = (int)room.getPosition().x * Room.ROOM_WIDTH;
						targetY = (int)room.getPosition().y * Room.ROOM_HEIGHT + (Room.ROOM_HEIGHT / 2);
						wallsList.remove(getWall(targetX, targetY));
						wallsList.add(new Empty(targetX, targetY, this));
					}
				}
				compass = (compass + 1) % 4;
			}
		}
	}
	
	public void printFloorplan() {
		
		GameObject[][] wholeFloor = new GameObject[FLOOR_SIZE*Room.ROOM_WIDTH][FLOOR_SIZE*Room.ROOM_HEIGHT];
		for (GameObject obj : wallsList) {
			wholeFloor[obj.getPosition().x][obj.getPosition().y] = obj;
		}
		for (GameObject obj : furnitureList) {
			wholeFloor[obj.getPosition().x][obj.getPosition().y] = obj;
		}
		for (GameObject obj : itemsList) {
			wholeFloor[obj.getPosition().x][obj.getPosition().y] = obj;
		}
		for (GameObject obj : entitiesList) {
			wholeFloor[obj.getPosition().x][obj.getPosition().y] = obj;
		}
		
		for (int i = topRow; i < bottom; i++) {
			for (int j = leftSide; j < FLOOR_SIZE*Room.ROOM_WIDTH; j++) {
				if (wholeFloor[j][i] != null) {
					System.out.print(wholeFloor[j][i].getAscii() + " ");
				}else {
					System.out.print("  ");
				}
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}
	
	private void followCompass() {
		newX = oldX;
		newY = oldY;
		
		switch (compass) {
		case 0:
			newY = oldY - 1;
			break;
		case 1:
			newX = oldX + 1;
			break;
		case 2:
			newY = oldY + 1;
			break;
		default:
			newX = oldX - 1;
			break;
		}
	}

}
