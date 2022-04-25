package main.java.effect;

import main.java.object.Entity;

public class Poison extends Effect{

	public Poison(Entity owner) {
		super(owner);
		type = PROC_TYPE.TICK;
		proc_ammo = 10;
		stackable = false;
	}
	
	@Override
	public void proc() {
		super.proc();
		owner.damage(5);
		exhaust();
	}

}
