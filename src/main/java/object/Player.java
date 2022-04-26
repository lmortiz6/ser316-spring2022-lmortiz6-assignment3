package main.java.object;

import main.java.system.Floor;
import main.java.system.Game;

public class Player extends Entity{
	
	//private int gold;

	public Player(int x, int y, Floor floor) {
		super(x, y, floor);
		ascii = '@';
	}
	
	@Override
	public void endTurn() {
		super.endTurn();
		Game.enemyTurn();
	}
	
	@Override
	public void destroy() {
		Game.gameOver();
	}
	
	@Override
	public boolean validTarget(Entity target) {
		return (target instanceof Enemy);
	}

}
