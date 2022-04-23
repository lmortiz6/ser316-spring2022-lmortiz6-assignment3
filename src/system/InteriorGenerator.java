package system;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class InteriorGenerator {
	
	

	long seed;
	Random rng;
	
	public InteriorGenerator(long sd) {
		seed = sd;
		rng = new Random(seed);
	}
	
	public void generateInterior(Room room, int floor) {
		Room.ROOM_TYPE type = room.getType();
		
		switch (type) {
		case START:
			generateStart(room);
			break;
		case TREASURE:
			generateTreasure(room, floor);
			break;
		case SHOP:
			generateShop(room, floor);
			break;
		case END:
			generateEnd(room, floor);
			break;
		default:
			generateNormal(room, floor);
			break;
		}
	}
	
	private void generateStart(Room room) {
		int roomX = room.getPosition().x * Room.ROOM_WIDTH;
		int roomY = room.getPosition().y * Room.ROOM_HEIGHT;
		int targetX = 0;
		int targetY = 0;
		
		//TODO spawn player
	}
	
	private void generateTreasure(Room room, int floor) {
		int roomX = room.getPosition().x * Room.ROOM_WIDTH;
		int roomY = room.getPosition().y * Room.ROOM_HEIGHT;
		int targetX = 0;
		int targetY = 0;
		
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < Room.ROOM_WIDTH - 1; j++) {
				if (j != 4) {
					room.addObject(new Wall(roomX+j, roomY+targetY), j, targetY);
				}
			}
			targetY = Room.ROOM_HEIGHT - 2;
		}
		
		//TODO spawn treasure
	}
	
	private void generateShop(Room room, int floor) {
		GameObject[][] objectGrid = room.getObjectGrid();
		int roomX = room.getPosition().x * Room.ROOM_WIDTH;
		int roomY = room.getPosition().y * Room.ROOM_HEIGHT;
		int targetX = 0;
		int targetY = 0;
		
		room.addObject(new Wall(roomX+targetX, roomY+targetY), targetX, targetY);
		targetX = Room.ROOM_WIDTH - 2;
		room.addObject(new Wall(roomX+targetX, roomY+targetY), targetX, targetY);
		targetY = Room.ROOM_HEIGHT - 2;
		room.addObject(new Wall(roomX+targetX, roomY+targetY), targetX, targetY);
		targetX = 0;
		room.addObject(new Wall(roomX+targetX, roomY+targetY), targetX, targetY);
		
		//TODO spawn shopkeeper
	}
	
	private void generateEnd(Room room, int floor) {
		int roomX = room.getPosition().x * Room.ROOM_WIDTH;
		int roomY = room.getPosition().y * Room.ROOM_HEIGHT;
		int targetX = 0;
		int targetY = 0;
		
		//TODO spawn boss/stairs
	}
	
	private void generateNormal(Room room, int floor) {
		addWalls(room);
		int roomX = room.getPosition().x * Room.ROOM_WIDTH;
		int roomY = room.getPosition().y * Room.ROOM_HEIGHT;
		int targetX = 0;
		int targetY = 0;
		
		//TODO spawn enemies/items
	}
	
	private void addWalls(Room room) {
		int roomX = room.getPosition().x * Room.ROOM_WIDTH;
		int roomY = room.getPosition().y * Room.ROOM_HEIGHT;
		int targetX = 0;
		int targetY = 0;
		int margin = 1 + rng.nextInt(2); // 1-2
		int layoutChoice = rng.nextInt(3); // 0-2
		Wall wall = null;
		
		if (layoutChoice == 0) { // 33%
			// cross pattern
			targetX = (Room.ROOM_WIDTH - 1) / 2;
			for (int i = margin; i < Room.ROOM_HEIGHT - 2 - margin; i++) {
				if (rng.nextInt(5) != 0) { // 80%
					wall = new Wall(roomX+targetX, roomY+i);
					room.addObject(wall, targetX, i);
				}
			}
			targetY = (Room.ROOM_HEIGHT - 1) / 2;
			for (int i = margin; i < Room.ROOM_WIDTH - 2 - margin; i++) {
				if (rng.nextInt(5) != 0) { // 80%
					wall = new Wall(roomX+i, roomY+targetY);
					room.addObject(wall, i, targetY);
				}
			}
		}
		else if (layoutChoice == 1){ // 33%
			// pillar pattern
			targetX = margin;
			targetY = margin;
			wall = new Wall(roomX+targetX, roomY+targetY);
			room.addObject(wall, targetX, targetY);
			targetX = Room.ROOM_WIDTH - 2 - margin;
			room.addObject(new Wall(roomX+targetX, roomY+targetY), targetX, targetY);
			targetY = Room.ROOM_HEIGHT - 2 - margin;
			room.addObject(new Wall(roomX+targetX, roomY+targetY), targetX, targetY);
			targetX = margin;
			room.addObject(new Wall(roomX+targetX, roomY+targetY), targetX, targetY);
		}
		// else add no walls 33%
	}

}
