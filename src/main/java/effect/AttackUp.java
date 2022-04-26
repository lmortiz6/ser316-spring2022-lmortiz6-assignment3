package main.java.effect;

import main.java.object.Entity;

public class AttackUp extends Effect{
	
	double mod;
	boolean requiresStart;
	boolean requiresFullHp;

	public AttackUp(Entity owner, boolean onStart, boolean onFull) {
		super(owner);
		proc_ammo = 1;
		modifier = 50;
		mod = 1 + ((double)modifier * 0.01);
		type = PROC_TYPE.ATTACK;
		requiresStart = onStart;
		requiresFullHp = onFull;
	}
	
	@Override
	public void setMod(int m) {
		super.setMod(m);
		mod = 1 + ((double)modifier * 0.01);
	}
	
	@Override
	public void proc() {
		if ((!requiresStart && !requiresFullHp) || (requiresStart && owner.getEnergy() == owner.getMaxEnergy()) || (requiresFullHp && owner.getHP() == owner.getMaxHP()))
		super.proc();
		owner.modifyDamage(mod);
		exhaust();
	}

}
