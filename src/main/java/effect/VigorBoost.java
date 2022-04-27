package main.java.effect;

import main.java.object.Entity;

public class VigorBoost extends Effect{

	public VigorBoost(Entity owner) {
		super(owner);
		type = PROC_TYPE.TURN;
		proc_ammo = -1;
		stackable = false;
	}
	
	@Override
	public void proc() {
		super.proc();
		int bonus = getBonus();
		owner.modifyHp(bonus);
	}
	
	private int getBonus() {
		int bonus = -11-12-13-14;
		int vig = Math.max(owner.getVigor(), 6);
		switch (Math.min(vig, 20)) {
		case 6:
			bonus = -11-12-13-14;
			return bonus;
		case 7:
			bonus = -11-12-13;
			return bonus;
		case 8:
			bonus = -11-12;
			return bonus;
		case 9:
			bonus = -11;
			return bonus;
		case 10:
			bonus = 0;
			return bonus;
		case 11:
			bonus = 10;
			return bonus;
		case 12:
			bonus = 10+10;
			return bonus;
		case 13:
			bonus = 10+10+10;
			return bonus;
		case 14:
			bonus = 10+10+10+10;
			return bonus;
		case 15:
			bonus = 10+10+10+10+9;
			return bonus;
		case 16:
			bonus = 10+10+10+10+9+8;
			return bonus;
		case 17:
			bonus = 10+10+10+10+9+8+7;
			return bonus;
		case 18:
			bonus = 10+10+10+10+9+8+7+6;
			return bonus;
		case 19:
			bonus = 10+10+10+10+9+8+7+6+5;
			return bonus;
		case 20:
			bonus = 10+10+10+10+9+8+7+6+5+4;
			return bonus;
		default:
			return bonus;
		}
	}

}
