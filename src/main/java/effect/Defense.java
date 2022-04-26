package main.java.effect;

import main.java.object.Entity;

public class Defense extends Effect{
	
	double mod;

	public Defense(Entity owner) {
		super(owner);
		type = PROC_TYPE.TURN;
		proc_ammo = 1;
		modifier = 30;
		mod = 1 + ((double)modifier * 0.01);
	}
	
	@Override
	public void setMod(int amount) {
		modifier = amount;
		mod = 1 + ((double)modifier * 0.01);
	}
	
	@Override
	public void proc() {
		super.proc();
		owner.modifyDefense(mod);
		exhaust();
	}

}
