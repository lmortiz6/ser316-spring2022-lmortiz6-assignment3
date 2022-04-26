package main.java.effect;

import main.java.object.Entity;

public class LuckBoost extends Effect{

	public LuckBoost(Entity owner) {
		super(owner);
		type = PROC_TYPE.TURN;
		proc_ammo = -1;
		stackable = false;
	}
	
	@Override
	public void proc() {
		super.proc();
		int bonus = getBonus();
		owner.modifySavingThrow(bonus);
	}
	
	private int getBonus() {
		int bonus = -2;
		int lck = Math.max(owner.getLuck(), 6);
		switch (Math.min(lck, 20)) {
		case 6:
			bonus = -8;
			return bonus;
		case 7:
			bonus = -6;
			return bonus;
		case 8:
			bonus = -4;
			return bonus;
		case 9:
			bonus = -2;
			return bonus;
		case 10:
			bonus = 0;
			return bonus;
		case 11:
			bonus = 2;
			return bonus;
		case 12:
			bonus = 4;
			return bonus;
		case 13:
			bonus = 5;
			return bonus;
		case 14:
			bonus = 6;
			return bonus;
		case 15:
			bonus = 6;
			return bonus;
		case 16:
			bonus = 7;
			return bonus;
		case 17:
			bonus = 7;
			return bonus;
		case 18:
			bonus = 8;
			return bonus;
		case 19:
			bonus = 8;
			return bonus;
		case 20:
			bonus = 9;
			return bonus;
		default:
			return bonus;
		}
	}

}
