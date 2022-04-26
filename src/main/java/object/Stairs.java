package main.java.object;

import main.java.system.Floor;

public class Stairs extends Item{

	public Stairs(int x, int y, Floor floor) {
		super(x, y, floor);
		ascii = '⤋';
	}
	
	@Override
	public void pickUp(Entity entity) {
		entity.endTurn();
		main.java.system.Game.nextFloor();
	}
}
