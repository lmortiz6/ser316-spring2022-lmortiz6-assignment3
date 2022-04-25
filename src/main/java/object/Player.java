package main.java.object;

import main.java.system.Floor;

public class Player extends Entity{

	public Player(int x, int y, Floor floor) {
		super(x, y, floor);
		ascii = '@';
	}
	
	@Override
	public boolean validTarget(Entity target) {
		return (target instanceof Enemy);
	}

}
