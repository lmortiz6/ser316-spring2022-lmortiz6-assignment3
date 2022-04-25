package main.java.object;

import main.java.system.Ai;
import main.java.system.Floor;

public class Enemy extends Entity{
	
	private Ai ai;

	public Enemy(int x, int y, Floor floor, Ai ai) {
		super(x, y, floor);
		this.ai = ai;
	}
	
	@Override
	public void takeTurn() {
		super.takeTurn();
		ai.start();
	}
	
	@Override
	public boolean validTarget(Entity target) {
		return (target instanceof Player);
	}
	
	@Override
	public void destroy() {
		super.destroy();
		if (dropItem != null) {
			dropItem.setPosition(position.x, position.y);
			dropItem.setFloor(floor);
			floor.addItem(dropItem);
		}
	}

}
