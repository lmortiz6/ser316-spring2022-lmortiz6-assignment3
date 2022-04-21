package system;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

import system.Room.ROOM_TYPE;

public class FloorGenerator {

	long seed;
	Random rng;
	RoomGenerator rgen = new RoomGenerator(seed);
	
	public FloorGenerator(long sd) {
		seed = sd;
		rng = new Random(seed);
	}
	
	public Floor generateFloor() {
		Layout layout = generateLayout();
		return new Floor(layout);
	}
	
	public Layout generateLayout() {
		Layout layout = new Layout();
		Point coord = new Point(Floor.FLOOR_SIZE / 2, Floor.FLOOR_SIZE / 2);
		
		// place starting room
		Room room = new Room(coord.x, coord.y, ROOM_TYPE.START);
		layout.addRoom(room, coord.x, coord.y);
		
		// place main path
		RoomPlacer placer = new RoomPlacer(layout);
		placer.mainPath();
		
		// place extra rooms
		placer.addExtra();
		
		//printLayout(layout);
		
		return layout;
	}
	
	private void printLayout(Layout layout) {
		for (int i = 0; i < Floor.FLOOR_SIZE; i++) {
			for (int j = 0; j < Floor.FLOOR_SIZE; j++) {
				switch (layout.getType(j, i)) {
				case START:
					System.out.print("X");
					break;
				case NORMAL:
					System.out.print("O");
					break;
				case END:
					System.out.print("E");
					break;
				case TREASURE:
					System.out.print("T");
					break;
				case SHOP:
					System.out.print("S");
					break;
				default:
					System.out.print(" ");
					break;
				}
			}
			System.out.print("\n");
		}
	}
	
	private class RoomPlacer {
		ArrayList<Room> rooms;
		Layout layout;
		int mainCount;
		int extraCount;
		int specCount;
		int compass;
		int oldX, oldY, newX, newY;
		
		public RoomPlacer(Layout lout) {
			layout = lout;
			rooms = new ArrayList<Room>(layout.getRoomList());
			mainCount = 4 + rng.nextInt(3); // 4-6
			extraCount = 2 + rng.nextInt(2); // 2-3
			specCount = 1 + rng.nextInt(2); // 1-2
			compass = 0; // 0=NORTH, 1=EAST, 2=SOUTH, 3=WEST
		}
		
		public void mainPath() {
			compass = rng.nextInt(4); // 0-3
			int turns = 2;
			Room newRoom;
			
			for (int i = 0; i < mainCount - 1; i++) {
				if (turns > 0) {
					if (rng.nextInt(3) == 0) { // 30%
						if (rng.nextInt(2) == 0) { // 50%
							compass = (compass + 1) % 4;
						}
						else {
							compass = (compass - 1) % 4;
						}
						turns--;
					}
				}
				
				oldX = rooms.get(i).getPosition().x;
				oldY = rooms.get(i).getPosition().y;
				
				followCompass();
				
				newRoom = new Room(newX, newY, ROOM_TYPE.NORMAL);
				layout.addRoom(newRoom, newX, newY);
				rooms.add(newRoom);
			}
			
			oldX = rooms.get(mainCount - 1).getPosition().x;
			oldY = rooms.get(mainCount - 1).getPosition().y;

			followCompass();
			
			newRoom = new Room(newX, newY, ROOM_TYPE.END);
			layout.addRoom(newRoom, newX, newY);
		}
		
		public void addExtra() {
			boolean foundPlace = false;
			int choice = 0;
			Room target = null;
			Room newRoom = null;
			
			for (int i = 0; i < extraCount; i++) {
				compass = rng.nextInt(4); // 0-3
				choice = rng.nextInt(mainCount + i);
				target = rooms.get(choice);
				oldX = target.getPosition().x;
				oldY = target.getPosition().y;
				for (int j = 0; j < 4 && !foundPlace; j++) {
					followCompass();
					if (layout.getType(newX, newY) == ROOM_TYPE.NULL) {
						newRoom = new Room(newX, newY, ROOM_TYPE.NORMAL);
						layout.addRoom(newRoom, newX, newY);
						rooms.add(newRoom);
						foundPlace = true;
					}
					else {
						compass = (compass + 1) % 4;
					}
				}
				if (foundPlace) {
					foundPlace = false;
				}
				else {
					i--;
				}
			}
			
			for (int i = 0; i < specCount; i++) {
				compass = rng.nextInt(4); // 0-3
				choice = rng.nextInt(mainCount + extraCount);
				target = rooms.get(choice);
				oldX = target.getPosition().x;
				oldY = target.getPosition().y;
				for (int j = 0; j < 4 && !foundPlace; j++) {
					followCompass();
					if (layout.getType(newX, newY) == ROOM_TYPE.NULL) {
						if (i != 1) {
							newRoom = new Room(newX, newY, ROOM_TYPE.TREASURE);
						}
						else {
							newRoom = new Room(newX, newY, ROOM_TYPE.SHOP);
						}
						layout.addRoom(newRoom, newX, newY);
						foundPlace = true;
					}
					else {
						compass = (compass + 1) % 4;
					}
				}
				if (foundPlace) {
					foundPlace = false;
				}
				else {
					i--;
				}
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
}
