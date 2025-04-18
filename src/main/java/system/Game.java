package main.java.system;

import java.util.ArrayList;
import java.util.Random;

import main.java.object.Enemy;
import main.java.object.GameObject;
import main.java.object.Player;
import main.java.object.Relic;

public class Game {
	public static Random dice;
	public static Random levelrng;
	public static Player player;
	public static Floor currentFloor;
	public static int currentFloorNum;
	public static boolean playerTurn;
	private static ArrayList<Floor> floors;
	
	public static void start(long seed, int character, String name) {
		dice = new Random(seed);
		levelrng = new Random(seed);
		floors = new ArrayList<Floor>();
		currentFloorNum = 0;
		
		if (character == -1) {
			player = PlayerGenerator.genPlayer(name, 0);
		}
		else {
			player = PlayerGenerator.genPlayer(name, character);
		}
		
		Floor floor = FloorGenerator.generateFloor(currentFloorNum);
		floors.add(floor);
		currentFloor = floor;
		
		if (character != -1)
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
		currentFloorNum += 1;
		main.java.ui.App.getFrame().log("Made it to floor " + (currentFloorNum + 1));
		Floor floor = FloorGenerator.generateFloor(currentFloorNum);
		floors.add(floor);
		currentFloor = floor;
		
		// curse applied to player every 5 floors advanced
		if (currentFloorNum % 5 == 0) {
			Relic curse = (Relic)ItemPool.pull("curse", 0, 0, currentFloor);
			player.addItem(curse);
			curse.pickUp(player);
		}
		playerTurn();
	}
	
	public static void gameOver() {
		main.java.ui.App.getFrame().gameOver();
	}

}
