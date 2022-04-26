package main.java.effect;

import main.java.object.Empty;
import main.java.object.Entity;
import main.java.system.Floor;
import main.java.system.Game;

public class Teleport extends Effect{
	
	boolean chance;

	public Teleport(Entity owner) {
		super(owner);
		proc_ammo = 1;
	}
	
	@Override
	public void proc() {
		
		if (modifier == -1) {
			chance = Game.dice.nextInt(6) == 0;
		}
		else {
			chance = true;
		}
		
		if (!chance) {
			return;
		}
		
		super.proc();
		
		Floor floor = Game.currentFloor;
		int top = floor.getTop();
		int left = floor.getLeft();
		int bottom = floor.getBottom();
		int right = floor.getRight();
		
		int x = 0;
		int y = 0;
		int exit = 0;
		
		while (!(floor.getObject(x, y) instanceof Empty) && exit < 30) {
			x = left + Game.dice.nextInt(right - left);
			y = top + Game.dice.nextInt(bottom - top);
			exit++;
		}
		
		if (exit < 30) {
			owner.move(x, y);
		}
		
		exhaust();
	}
	
}
