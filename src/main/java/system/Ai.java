package main.java.system;

import main.java.object.Entity;

public class Ai {
	
	protected Entity owner;
	protected int maxActions;
	protected int actions;
	
	public Ai() {}
	
	public void setOwner(Entity owner) {
		this.owner = owner;
	}
	
	public void start() {
		actions = 0;
		while (actions < maxActions && owner.getEnergy() > 0) {
			act();
			actions++;
		}
		end();
	}
	
	protected void act() {
		
	}
	
	protected void end() {
		owner.endTurn();
	}
}
