package system;

import java.util.ArrayList;

public class Layout {
	private Room[][] rooms;
	private ArrayList<Room> roomList;
	private int numRooms;
	
	public Layout() {
		rooms = new Room[Floor.FLOOR_SIZE][Floor.FLOOR_SIZE];
		roomList = new ArrayList<Room>();
	}
	
	public void addRoom(Room rm, int x, int y) {
		rooms[x][y] = rm;
		roomList.add(rm);
		numRooms++;
	}
	
	public Room.ROOM_TYPE getType(int x, int y) {
		Room rm = null;
		try {
			rm = rooms[x][y];
		}
		catch (Exception ex) {
			return Room.ROOM_TYPE.NULL;
		}
		if (rm != null) {
			Room.ROOM_TYPE type = rm.getType();
			
			return type;
		}else {
			return Room.ROOM_TYPE.NULL;
		}
	}
	
	public int getRoomCount() {
		return numRooms;
	}
	
	public ArrayList<Room> getRoomList() {
		return roomList;
	}
}
