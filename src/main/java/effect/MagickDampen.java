package main.java.effect;

import main.java.object.Entity;

public class MagickDampen extends Effect{
	
	double mod;

	public MagickDampen(Entity owner) {
		super(owner);
		type = PROC_TYPE.TURN;
		proc_ammo = 1;
		modifier = 40;
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
		owner.modifyMagick(mod);
		exhaust();
	}

}
