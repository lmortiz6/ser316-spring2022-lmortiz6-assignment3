package main.java.effect;

import main.java.object.Entity;

public class EnGain extends Effect{

	public EnGain(Entity owner) {
		super(owner);
		proc_ammo = 1;
		modifier = 2;
	}
	
	@Override
	public void proc() {
		super.proc();
		owner.enGain(modifier);
		exhaust();
	}
}
