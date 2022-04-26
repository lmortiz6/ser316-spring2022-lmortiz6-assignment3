package main.java.object;

import main.java.system.Floor;

public class LevelUp extends Skill{

	public LevelUp(int x, int y, Floor floor) {
		super(x, y, floor);
		name = "Level Up";
		desc = "Use skill points to level up stats.";
		
	}
	
	@Override
	public int getSpCost() {
		return 1;
	}
	
	@Override
	public void use(String direction) {
		if (!(owner.getSP() > 0)) {
			return;
		}
		// TODO open level menu
		owner.spGain(-1);
	}

}
