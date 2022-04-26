package main.java.system;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

import main.java.object.Empty;
import main.java.object.Stairs;
import main.java.object.Wall;

public class InteriorGenerator {
	
	

	long seed;
	Random rng;
	
	public InteriorGenerator(long sd) {
		seed = sd;
		rng = Game.levelrng;
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
			case SHOP: // shop not yet implemented
				generateTreasure(floor, room, floorNum);
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
						floor.addFurniture(new Empty(j + room.getPositionAbs().x, i + room.getPositionAbs().y, floor));
					}
				}
			}
		}
	}
	
	private void generateStart(Floor floor, Room room) {
		int roomX = room.getPositionAbs().x;
		int roomY = room.getPositionAbs().y;
		int targetX = roomX + (Room.ROOM_WIDTH / 2);
		int targetY = roomY + (Room.ROOM_HEIGHT / 2);
		
		// spawn player
		floor.addEntity(Game.player);
		Game.player.setFloor(floor);
		Game.player.setPosition(targetX, targetY);
	}
	
	private void generateTreasure(Floor floor, Room room, int floorNum) {
		int roomX = room.getPositionAbs().x;
		int roomY = room.getPositionAbs().y;
		int targetX = 1;
		int targetY = 1;
		
		for (int i = 0; i < 2; i++) {
			for (int j = 1; j < Room.ROOM_WIDTH; j++) {
				if (j != 5) {
					floor.addFurniture(new Wall(roomX+j, roomY+targetY, floor));
				}
			}
			targetY = Room.ROOM_HEIGHT - 1;
		}
		
		// spawn treasure
		
		targetX = roomX + (Room.ROOM_WIDTH / 2);
		targetY = roomY + (Room.ROOM_HEIGHT / 2);
		
		floor.addItem(ItemPool.pull("treasure", targetX, targetY, floor));
		
	}
	
	/*// unused
	private void generateShop(Floor floor, Room room, int floorNum) {
		int roomX = room.getPositionAbs().x;
		int roomY = room.getPositionAbs().y;
		int targetX = 1;
		int targetY = 1;
		
		floor.addFurniture(new Wall(roomX+targetX, roomY+targetY, floor));
		targetX = Room.ROOM_WIDTH - 1;
		floor.addFurniture(new Wall(roomX+targetX, roomY+targetY, floor));
		targetY = Room.ROOM_HEIGHT - 1;
		floor.addFurniture(new Wall(roomX+targetX, roomY+targetY, floor));
		targetX = 1;
		floor.addFurniture(new Wall(roomX+targetX, roomY+targetY, floor));
		
		//TODO spawn shopkeeper
	}*/
	
	private void generateEnd(Floor floor, Room room, int floorNum) {
		int roomX = room.getPositionAbs().x;
		int roomY = room.getPositionAbs().y;
		int targetX = 0;
		int targetY = 0;
		
		// spawn boss
		targetX = roomX + (Room.ROOM_WIDTH / 2) + 1;
		targetY = roomY + (Room.ROOM_HEIGHT / 2);
		
		if ((Game.currentFloorNum + 1) % 2 == 0) {
			floor.addEntity(EnemyPool.pull("elite", targetX, targetY, floor));
		}
		else if ((Game.currentFloorNum + 1) % 5 == 0) {
			floor.addEntity(EnemyPool.pull("boss", targetX, targetY, floor));
		}
		
		// spawn stairs
		targetX -= 2;
		floor.addItem(new Stairs(targetX, targetY, floor));
	}
	
	private void generateNormal(Floor floor, Room room, int floorNum) {
		addWalls(floor, room);
		int roomX = room.getPositionAbs().x;
		int roomY = room.getPositionAbs().y;
		int targetX = 0;
		int targetY = 0;
		
		// spawn enemies
		
		// 1-8 enemies, depending on rng and progression
		int count = 1 + rng.nextInt(Math.min(8, Math.max(Game.currentFloorNum / 2, 3)));
		int loops;
		String pool = "" + Math.min(5, Game.currentFloorNum + 1);
		
		for (int i = 0; i < count; i++) {
			loops = 0;
			while (!(floor.getObject(targetX, targetY) instanceof main.java.object.Empty) && loops < 30) {
				targetX = roomX + 1 + Game.dice.nextInt(Room.ROOM_WIDTH - 1);
				targetY = roomY + 1 + Game.dice.nextInt(Room.ROOM_HEIGHT - 1);
				loops++;
			}
			if (loops < 30) {
				floor.addEntity(EnemyPool.pull(pool, targetX, targetY, floor));
			}
		}
		
		// spawn item
		if (rng.nextInt(6) == 0) {
			loops = 0;
			while (!(floor.getObject(targetX, targetY) instanceof main.java.object.Empty) && loops < 30) {
				targetX = roomX + 1 + Game.dice.nextInt(Room.ROOM_WIDTH - 1);
				targetY = roomY + 1 + Game.dice.nextInt(Room.ROOM_HEIGHT - 1);
				loops++;
			}
			if (loops < 30) {
				floor.addItem(ItemPool.pull(pool, targetX, targetY, floor));
			}
		}
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
					floor.addFurniture(new Wall(roomX+targetX, roomY+i, floor));
				}
			}
			targetY = Room.ROOM_HEIGHT / 2;
			for (int i = margin+1; i < Room.ROOM_WIDTH - 1 - margin; i++) {
				if (rng.nextInt(5) != 0) { // 80%
					floor.addFurniture(new Wall(roomX+i, roomY+targetY, floor));
				}
			}
		}
		else if (layoutChoice == 1){ // 33%
			// pillar pattern
			targetX = margin+1;
			targetY = margin+1;
			floor.addFurniture(new Wall(roomX+targetX, roomY+targetY, floor));
			targetX = Room.ROOM_WIDTH - 1 - margin;
			floor.addFurniture(new Wall(roomX+targetX, roomY+targetY, floor));
			targetY = Room.ROOM_HEIGHT - 1 - margin;
			floor.addFurniture(new Wall(roomX+targetX, roomY+targetY, floor));
			targetX = margin + 1;
			floor.addFurniture(new Wall(roomX+targetX, roomY+targetY, floor));
		}
		// else add no walls 33%
	}

}
