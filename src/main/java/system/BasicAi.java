package main.java.system;

import main.java.object.Entity;

public class BasicAi extends Ai{
	
	public static final int AGGRO_RANGE = 8;

	public BasicAi() {
		super();
		maxActions = 4;
		actions = 0;
	}
	
	@Override
	public void act() {
		int diffX = Game.player.getPosition().x - owner.getPosition().x;
		int diffY = Game.player.getPosition().y - owner.getPosition().y;
		
		if (Math.abs(diffX) > AGGRO_RANGE+aggroBonus || Math.abs(diffY) > AGGRO_RANGE+aggroBonus) {
			return;
		}
		
		if (diffX == 0 && Math.abs(diffY) == 1) {
			switch (diffY) {
			case -1:
				owner.attack("NORTH");
				return;
			case 1:
				owner.attack("SOUTH");
				return;
			default:
				return;
			}
		}
		if (diffY == 0 && Math.abs(diffX) == 1) {
			switch (diffX) {
			case -1:
				owner.attack("WEST");
				return;
			case 1:
				owner.attack("EAST");
				return;
			default:
				return;
			}
		}
		
		if (Math.abs(diffX) > Math.abs(diffY)) {
			switch ((int)Math.signum(diffX)) {
			case -1:
				owner.move("WEST");
				return;
			case 1:
				owner.move("EAST");
			default:
				return;
			}
		}
		else {
			switch ((int)Math.signum(diffY)) {
			case -1:
				owner.move("NORTH");
				return;
			case 1:
				owner.move("SOUTH");
			default:
				return;
			}
		}
	}

}
