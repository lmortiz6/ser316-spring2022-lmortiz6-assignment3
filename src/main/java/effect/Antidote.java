package main.java.effect;

import main.java.object.Entity;

public class Antidote extends Effect{

	public Antidote(Entity owner) {
		super(owner);
		proc_ammo = 1;
	}
	
	@Override
	public void proc() {
		super.proc();
		for (Effect effect : owner.getEffects()) {
			if (effect instanceof Poison) {
				owner.removeEffect(effect);
			}
		}
		owner.removeEffects();
	}
	
}
