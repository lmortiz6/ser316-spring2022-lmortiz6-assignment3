package main.java.effect;

import main.java.object.Entity;

public class Bleed extends Effect{

	public Bleed(Entity owner) {
		super(owner);
		type = PROC_TYPE.DAMAGED;
		proc_ammo = 1;
		stackable = false;
	}

	@Override
	public void proc() {
		super.proc();
		owner.damageNoEffects((int)(owner.getMaxHP() * 0.25));
		exhaust();
	}
}
