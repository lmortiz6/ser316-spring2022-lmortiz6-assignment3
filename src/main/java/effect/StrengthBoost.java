package main.java.effect;

import main.java.object.Entity;

public class StrengthBoost extends Effect{

	public StrengthBoost(Entity owner) {
		super(owner);
		type = PROC_TYPE.TURN;
		proc_ammo = -1;
		stackable = false;
	}
	
	@Override
	public void proc() {
		super.proc();
		double bonus = getBonus();
		owner.modifyDamage(bonus);
	}
	
	private double getBonus() {
		double bonus = 0.8;
		int str = Math.max(owner.getStrength(), 6);
		switch (Math.min(str, 20)) {
		case 6:
			bonus = 0.8;
			return bonus;
		case 7:
			bonus = 0.85;
			return bonus;
		case 8:
			bonus = 0.9;
			return bonus;
		case 9:
			bonus = 0.95;
			return bonus;
		case 10:
			bonus = 1;
			return bonus;
		case 11:
			bonus = 1.05;
			return bonus;
		case 12:
			bonus = 1.1;
			return bonus;
		case 13:
			bonus = 1.15;
			return bonus;
		case 14:
			bonus = 1.2;
			return bonus;
		case 15:
			bonus = 1.25;
			return bonus;
		case 16:
			bonus = 1.3;
			return bonus;
		case 17:
			bonus = 1.35;
			return bonus;
		case 18:
			bonus = 1.4;
			return bonus;
		case 19:
			bonus = 1.45;
			return bonus;
		case 20:
			bonus = 1.5;
			return bonus;
		default:
			return bonus;
		}
	}

}
