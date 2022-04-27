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
	public void move(int x, int y) {
		if (en < WALK_COST + moveBonus) {
			endTurn();
		}
		super.move(x, y);
		main.java.ui.App.getFrame().asciiPane.repaint();
		main.java.ui.App.getFrame().controlPane.refresh();
	}
	
	@Override
	public void attack(String direction) {
		super.attack(direction);
		main.java.ui.App.getFrame().asciiPane.repaint();
		main.java.ui.App.getFrame().controlPane.refresh();
	}
	
	@Override
	public void pickUp() {
		super.pickUp();
		main.java.ui.App.getFrame().asciiPane.repaint();
		main.java.ui.App.getFrame().controlPane.refresh();
	}
	
	@Override
	public void takeTurn() {
		super.takeTurn();
		if (main.java.ui.App.getFrame() != null) {
			main.java.ui.App.getFrame().asciiPane.repaint();
			main.java.ui.App.getFrame().controlPane.refresh();
		}
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
