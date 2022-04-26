package main.java.system;

import java.util.Random;

import main.java.object.Player;

public class Game {
	public static Random dice = null;
	public static Random levelrng = null;
	public static Player player;
	public static Floor currentFloor;
	public static int currentFloorNum;
	
	public static void setUp(long seed) {
		dice = new Random(seed);
		levelrng = new Random(seed);
	}
	
	public static void nextFloor() {
		
	}

}
