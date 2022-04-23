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
	
	public void generateInterior(Floor floor, int floorNum) {
		for (Room room : floor.getLayout().getRoomList()) {
			Room.ROOM_TYPE type = room.getType();
			switch (type) {
			case START:
				generateStart(floor, room);
				break;
			case TREASURE:
				generateTreasure(floor, room, floorNum);
				break;
			case SHOP:
				generateShop(floor, room, floorNum);
				break;
			case END:
				generateEnd(floor, room, floorNum);
				break;
			default:
				generateNormal(floor, room, floorNum);
				break;
			}
			for (int i = 1; i < Room.ROOM_HEIGHT; i++) {
				for (int j = 1; j < Room.ROOM_WIDTH; j++) {
					if (floor.getFurniture(j + room.getPositionAbs().x, i + room.getPositionAbs().y) == null) {
						floor.addFurniture(new Empty(j + room.getPositionAbs().x, i + room.getPositionAbs().y));
					}
				}
			}
		}
	}
	
	private void generateStart(Floor floor, Room room) {
		int roomX = room.getPositionAbs().x;
		int roomY = room.getPositionAbs().y;
		int targetX = 0;
		int targetY = 0;
		
		//TODO spawn player
	}
	
	private void generateTreasure(Floor floor, Room room, int floorNum) {
		int roomX = room.getPositionAbs().x;
		int roomY = room.getPositionAbs().y;
		int targetX = 1;
		int targetY = 1;
		
		for (int i = 0; i < 2; i++) {
			for (int j = 1; j < Room.ROOM_WIDTH; j++) {
				if (j != 5) {
					floor.addFurniture(new Wall(roomX+j, roomY+targetY));
				}
			}
			targetY = Room.ROOM_HEIGHT - 1;
		}
		
		//TODO spawn treasure
	}
	
	private void generateShop(Floor floor, Room room, int floorNum) {
		int roomX = room.getPositionAbs().x;
		int roomY = room.getPositionAbs().y;
		int targetX = 1;
		int targetY = 1;
		
		floor.addFurniture(new Wall(roomX+targetX, roomY+targetY));
		targetX = Room.ROOM_WIDTH - 1;
		floor.addFurniture(new Wall(roomX+targetX, roomY+targetY));
		targetY = Room.ROOM_HEIGHT - 1;
		floor.addFurniture(new Wall(roomX+targetX, roomY+targetY));
		targetX = 1;
		floor.addFurniture(new Wall(roomX+targetX, roomY+targetY));
		
		//TODO spawn shopkeeper
	}
	
	private void generateEnd(Floor floor, Room room, int floorNum) {
		int roomX = room.getPositionAbs().x;
		int roomY = room.getPositionAbs().y;
		int targetX = 0;
		int targetY = 0;
		
		//TODO spawn boss/stairs
	}
	
	private void generateNormal(Floor floor, Room room, int floorNum) {
		addWalls(floor, room);
		int roomX = room.getPositionAbs().x;
		int roomY = room.getPositionAbs().y;
		int targetX = 0;
		int targetY = 0;
		
		//TODO spawn enemies/items
	}
	
	private void addWalls(Floor floor, Room room) {
		int roomX = room.getPositionAbs().x;
		int roomY = room.getPositionAbs().y;
		int targetX = 1;
		int targetY = 1;
		int margin = 1 + rng.nextInt(2); // 1-2
		int layoutChoice = rng.nextInt(3); // 0-2
		
		if (layoutChoice == 0) { // 33%
			// cross pattern
			targetX = Room.ROOM_WIDTH / 2;
			for (int i = margin+1; i < Room.ROOM_HEIGHT - 1 - margin; i++) {
				if (rng.nextInt(5) != 0) { // 80%
					floor.addFurniture(new Wall(roomX+targetX, roomY+i));
				}
			}
			targetY = Room.ROOM_HEIGHT / 2;
			for (int i = margin+1; i < Room.ROOM_WIDTH - 1 - margin; i++) {
				if (rng.nextInt(5) != 0) { // 80%
					floor.addFurniture(new Wall(roomX+i, roomY+targetY));
				}
			}
		}
		else if (layoutChoice == 1){ // 33%
			// pillar pattern
			targetX = margin+1;
			targetY = margin+1;
			floor.addFurniture(new Wall(roomX+targetX, roomY+targetY));
			targetX = Room.ROOM_WIDTH - 1 - margin;
			floor.addFurniture(new Wall(roomX+targetX, roomY+targetY));
			targetY = Room.ROOM_HEIGHT - 1 - margin;
			floor.addFurniture(new Wall(roomX+targetX, roomY+targetY));
			targetX = margin + 1;
			floor.addFurniture(new Wall(roomX+targetX, roomY+targetY));
		}
		// else add no walls 33%
	}

}
