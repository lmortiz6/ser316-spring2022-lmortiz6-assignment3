package main.java.effect;

import main.java.object.Entity;

public class Thorns extends Effect{

	public Thorns(Entity owner) {
		super(owner);
		proc_ammo = 1;
		type = PROC_TYPE.DAMAGED;
	}
	
	@Override
	public void proc() {
		if (owner.getAttacker() == null) {
			return;
		}
		super.proc();
		owner.getAttacker().damage(10);
		exhaust();
	}

}
