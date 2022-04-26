package main.java.system;

import java.util.ArrayList;
import java.util.Random;

import main.java.object.Enemy;
import main.java.object.GameObject;
import main.java.object.Player;

public class Game {
	public static Random dice;
	public static Random levelrng;
	public static Player player;
	public static Floor currentFloor;
	public static int currentFloorNum;
	public static boolean playerTurn;
	private static ArrayList<Floor> floors;
	
	public static void start(long seed, String character) {
		dice = new Random(seed);
		levelrng = new Random(seed);
		floors = new ArrayList<Floor>();
		currentFloorNum = 0;
		
		player = new Player(0, 0, null);
		//player = PlayerGenerator.genPlayer(character);
		Floor floor = FloorGenerator.generateFloor(0);
    	
    	main.java.object.Weapon weapon1 = new main.java.object.Weapon(0, 0, floor);
    	weapon1.setUp("Super Hammer", 300, 0, 0, 2, new Hitbox(1, 1));
    	
    	player.setUp("Tom", player.getAscii(), 100, 100, 4, 10, 10, 10, 10, 10, 10, null);
    	player.equipWeapon(weapon1);
    	
		floors.add(floor);
		
		floors.get(currentFloorNum).printFloorplan();
		
		currentFloor = floor;
		
		playerTurn();
	}
	
	public static void playerTurn() {
		playerTurn = true;
		player.takeTurn();
	}
	
	public static void enemyTurn() {
		playerTurn = false;
		for (GameObject obj : floors.get(currentFloorNum).getEntities()) {
			if (obj instanceof Enemy) {
				Enemy enemy = (Enemy)obj;
				enemy.takeTurn();
			}
		}
		playerTurn();
	}
	
	public static void nextFloor() {
		
	}
	
	public static void gameOver() {
		
	}

}
