package main.java.effect;

import main.java.object.Entity;

public class Bandage extends Effect{

	public Bandage(Entity owner) {
		super(owner);
		proc_ammo = 1;
		type = PROC_TYPE.TICK;
	}
	
	@Override
	public void proc() {
		super.proc();
		owner.removeEffects();
		exhaust();
	}
}
