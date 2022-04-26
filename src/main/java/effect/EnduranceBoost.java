package main.java.effect;

import main.java.object.Entity;

public class EnduranceBoost extends Effect{

	public EnduranceBoost(Entity owner) {
		super(owner);
		type = PROC_TYPE.TURN;
		proc_ammo = -1;
		stackable = false;
	}
	
	@Override
	public void proc() {
		super.proc();
		int bonus = getBonus();
		owner.modifyEn(bonus);
	}
	
	private int getBonus() {
		int bonus = -2;
		int end = Math.max(owner.getEndurance(), 6);
		switch (Math.min(end, 20)) {
		case 6:
			bonus = -2;
			return bonus;
		case 7:
			bonus = -1;
			return bonus;
		case 8:
			bonus = -1;
			return bonus;
		case 9:
			bonus = 0;
			return bonus;
		case 10:
			bonus = 0;
			return bonus;
		case 11:
			bonus = 1;
			return bonus;
		case 12:
			bonus = 1;
			return bonus;
		case 13:
			bonus = 1;
			return bonus;
		case 14:
			bonus = 2;
			return bonus;
		case 15:
			bonus = 2;
			return bonus;
		case 16:
			bonus = 2;
			return bonus;
		case 17:
			bonus = 3;
			return bonus;
		case 18:
			bonus = 3;
			return bonus;
		case 19:
			bonus = 3;
			return bonus;
		case 20:
			bonus = 4;
			return bonus;
		default:
			return bonus;
		}
	}

}
