package main.java.effect;

import main.java.object.Entity;

public class SavingThrowBoost extends Effect{

	public SavingThrowBoost(Entity owner) {
		super(owner);
		proc_ammo = 1;
		modifier = 5;
	}
	
	@Override
	public void proc() {
		super.proc();
		owner.modifySavingThrow(modifier);
		exhaust();
	}
}
