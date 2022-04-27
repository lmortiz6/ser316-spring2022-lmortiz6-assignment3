package main.java.system;
import java.util.Date;
import java.util.Scanner;

import main.java.object.Enemy;
import main.java.object.Player;
import main.java.ui.App;

public class Start {

	static App app = null;
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Welcome!\n Enter 'p' to play the game normally.\n"
				+ " Enter any other string to run a quick auto simulation in the console for grading.\n"
				+ " The game was made to run in 'p' mode, so exceptions might happen in the auto sim mode.\n");
		
		String input = 	scan.nextLine();
		
		if (input.toLowerCase().equals("p")) {
			System.out.println("Starting game...");
			app = new App(false);
		} else {
			System.out.println("Enter a name in the dialog, then simulate a few rounds (Name/class won't apply in this mode)\n"
					+ "The player is represented by the '@' symbol.\n"
					+ "Levels are procedurally generated based on seed.");
			app = new App(true);
			
			Date date = new Date();
			
			Game.start(date.getTime(), -1, "Logan");
			
			Player player = Game.player;
			
			BasicAi ai = new BasicAi();
			Enemy enemy = new Enemy(player.getPosition().x + 1, player.getPosition().y, Game.currentFloor, ai);
			ai.setOwner(enemy);
			
			enemy.setUp("Imp", 'i', 30, 30, 2, 15, 10, 10, 10, 10, 10, 
					ItemPool.pull("treasure", enemy.getPosition().x, enemy.getPosition().y, Game.currentFloor));
			
			Game.currentFloor.addEntity(enemy);
			
			Game.currentFloor.printFloorplan();
			
			// Simulate a few rounds
			// Attack a few times, then pick up the dropped item
			// It's possible that your attacks will miss enough times that the enemy won't die, it's RNG
			player.takeTurn();
			player.attack("EAST");
			player.endTurn();
			Game.currentFloor.printFloorplan();
			player.takeTurn();
			player.attack("EAST");
			player.endTurn();
			Game.currentFloor.printFloorplan();
			player.takeTurn();
			player.attack("EAST");
			player.endTurn();
			Game.currentFloor.printFloorplan();
			player.takeTurn();
			player.attack("EAST");
			player.endTurn();
			Game.currentFloor.printFloorplan();
			player.takeTurn();
			player.move("EAST");
			player.pickUp();
			player.endTurn();
			Game.currentFloor.printFloorplan();
			
		}
	}

}
