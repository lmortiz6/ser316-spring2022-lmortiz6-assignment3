package main.java.effect;

import main.java.object.Entity;

public class Heal extends Effect{
	
	boolean requiresKill;

	public Heal(Entity owner, boolean onKill) {
		super(owner);
		proc_ammo = 1;
		modifier = 40;
		requiresKill = onKill;
	}
	
	@Override
	public void proc() {
		if (!requiresKill || owner.killedEnemy()) {
			super.proc();
			owner.heal(modifier);
			exhaust();
		}
	}

}
