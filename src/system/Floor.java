package system;

import java.util.ArrayList;

public class Floor {
	
	public static int FLOOR_SIZE = 20;
	
	private Layout layout;
	Wall[][] walls = new Wall[FLOOR_SIZE*Room.ROOM_WIDTH][FLOOR_SIZE*Room.ROOM_HEIGHT];
	ArrayList<GameObject> objects;
	private int compass, oldX, oldY, newX, newY;
	
	public Floor(Layout lout) {
		layout = lout;
		generateWalls();
		makeDoors();
		printWalls();
	}
	
	private void generateWalls() {
		int targetX, targetY;
		
		for (Room room : layout.getRoomList()) {
			targetY = (int)room.getPosition().getY() * Room.ROOM_HEIGHT;
			for (int i = 0; i < Room.ROOM_WIDTH + 1; i++) {
				targetX = (int)room.getPosition().getX() * Room.ROOM_WIDTH + i;
				walls[targetX][targetY] = new Wall(targetX, targetY);
			}
			for (int i = 0; i < Room.ROOM_HEIGHT - 1; i++) {
				targetX = (int)room.getPosition().getX() * Room.ROOM_WIDTH;
				targetY = (int)room.getPosition().getY() * Room.ROOM_HEIGHT + 1 + i;
				walls[targetX][targetY] = new Wall(targetX, targetY);
				targetX += Room.ROOM_WIDTH;
				walls[targetX][targetY] = new Wall(targetX, targetY);
			}
			targetY = (int)room.getPosition().getY() * Room.ROOM_HEIGHT + Room.ROOM_HEIGHT;
			for (int i = 0; i < Room.ROOM_WIDTH + 1; i++) {
				targetX = (int)room.getPosition().getX() * Room.ROOM_WIDTH + i;
				walls[targetX][targetY] = new Wall(targetX, targetY);
			}
		}
	}
	
	private void makeDoors() {
		for (Room room : layout.getRoomList()) {
			compass = 0;
			oldX = room.getPosition().x;
			oldY = room.getPosition().y;
			
			for (int i = 0; i < 4; i++) {
				followCompass();
				if (layout.getType(newX, newY) != Room.ROOM_TYPE.NULL) {
					switch (compass) {
					case 0: // NORTH
						walls[(int)room.getPosition().x * Room.ROOM_WIDTH + (Room.ROOM_WIDTH / 2)]
							 [(int)room.getPosition().y * Room.ROOM_HEIGHT]
									 = null;
						break;
					case 1: // EAST
						walls[(int)room.getPosition().x * Room.ROOM_WIDTH + (Room.ROOM_WIDTH)]
							 [(int)room.getPosition().y * Room.ROOM_HEIGHT + (Room.ROOM_HEIGHT / 2)]
									 = null;
						break;
					case 2: // SOUTH
						walls[(int)room.getPosition().x * Room.ROOM_WIDTH + (Room.ROOM_WIDTH / 2)]
							 [(int)room.getPosition().y * Room.ROOM_HEIGHT + (Room.ROOM_HEIGHT)]
									 = null;
						break;
					case 3: // WEST
						walls[(int)room.getPosition().x * Room.ROOM_WIDTH]
							 [(int)room.getPosition().y * Room.ROOM_HEIGHT + (Room.ROOM_HEIGHT / 2)]
									 = null;
					}
				}
				compass = (compass + 1) % 4;
			}
		}
	}
	
	private void printWalls() {
		for (int i = 0; i < FLOOR_SIZE*Room.ROOM_HEIGHT; i++) {
			for (int j = 0; j < FLOOR_SIZE*Room.ROOM_WIDTH; j++) {
				if (walls[j][i] != null) {
					System.out.print("X ");
				}else {
					System.out.print("  ");
				}
			}
			System.out.print("\n");
		}
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
