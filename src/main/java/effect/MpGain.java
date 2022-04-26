package main.java.effect;

import main.java.object.Entity;

public class MpGain extends Effect{
	
	private boolean requiresKill;

	public MpGain(Entity owner) {
		super(owner);
		proc_ammo = 1;
		modifier = 40;
	}
	
	@Override
	public void proc() {
		super.proc();
		owner.mpGain(modifier);
		exhaust();
	}

}
