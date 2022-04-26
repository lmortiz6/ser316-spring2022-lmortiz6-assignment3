package main.java.system;

import main.java.object.Entity;

public class Ai {
	
	protected static int aggroBonus;
	
	protected Entity owner;
	protected int maxActions;
	protected int actions;
	
	public Ai() {
		aggroBonus = 0;
	}
	
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
	
	public static void modifyAggro(int amount) {
		aggroBonus += amount;
	}
}
