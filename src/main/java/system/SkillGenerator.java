package main.java.system;

import main.java.object.Skill;
import main.java.effect.*;

public class SkillGenerator {
	public static Skill genSkill(String name, int x, int y, Floor floor) {
		switch (name.toLowerCase()) {
		case "spark":
			return genSpark(x, y, floor);
		case "fireball":
			return genFireball(x, y, floor);
		case "poison":
			return genPoison(x, y, floor);
		case "lightning":
			return genLightning(x, y, floor);
		case "boulder":
			return genBoulder(x, y, floor);
		case "blood":
			return genBlood(x, y, floor);
		case "teleport":
			return genTeleport(x, y, floor);
		case "heal":
			return genHeal(x, y, floor);
		case "ritual":
			return genRitual(x, y, floor);
		default:
			return genSpark(x, y, floor);
		}
	}
	
	private static Skill genSpark(int x, int y, Floor floor) {
		Skill newSkill = new Skill(x, y, floor);
		String name = "Spark";
		int hpCost = 0;
		int mpCost = 7;
		int enCost = 0;
		int modifier = 3;
		int damage = 5;
		Hitbox hb = new Hitbox(1, 1);
		
		String desc = "Very weak spell with no energy cost.";
		
		newSkill.setUp(name, hpCost, mpCost, enCost, hb, modifier, damage);
		newSkill.setDesc(desc);
		
		return newSkill;
	}
	
	private static Skill genFireball(int x, int y, Floor floor) {
		Skill newSkill = new Skill(x, y, floor);
		String name = "Fireball";
		int hpCost = 0;
		int mpCost = 15;
		int enCost = 1;
		int modifier = 3;
		int damage = 25;
		Hitbox hb = new Hitbox(1, 1);
		
		String desc = "Strong, short range spell.";
		
		newSkill.setUp(name, hpCost, mpCost, enCost, hb, modifier, damage);
		newSkill.setDesc(desc);
		
		return newSkill;
	}
	
	private static Skill genPoison(int x, int y, Floor floor) {
		Skill newSkill = new Skill(x, y, floor);
		String name = "Poison Cloud";
		int hpCost = 0;
		int mpCost = 10;
		int enCost = 1;
		int modifier = 1;
		int damage = 0;
		Hitbox hb = new Hitbox(3, 3);
		
		String desc = "Poison enemies in large range.";
		
		newSkill.setUp(name, hpCost, mpCost, enCost, hb, modifier, damage);
		newSkill.setDesc(desc);
		
		return newSkill;
	}
	
	private static Skill genLightning(int x, int y, Floor floor) {
		Skill newSkill = new Skill(x, y, floor);
		String name = "Lightning Bolt";
		int hpCost = 12;
		int mpCost = 15;
		int enCost = 1;
		int modifier = 3;
		int damage = 38;
		Hitbox hb = new Hitbox(1, 2);
		
		String desc = "Greatly damaging spell with long range. Shocks the user as well.";
		
		newSkill.setUp(name, hpCost, mpCost, enCost, hb, modifier, damage);
		newSkill.setDesc(desc);
		
		return newSkill;
	}
	
	private static Skill genBoulder(int x, int y, Floor floor) {
		Skill newSkill = new Skill(x, y, floor);
		String name = "Manifest Boulder";
		int hpCost = 0;
		int mpCost = 25;
		int enCost = 2;
		int modifier = 0;
		int damage = 45;
		Hitbox hb = new Hitbox(3, 3);
		
		String desc = "Crush enemies in large range with boulder.";
		
		newSkill.setUp(name, hpCost, mpCost, enCost, hb, modifier, damage);
		newSkill.setDesc(desc);
		
		return newSkill;
	}
	
	private static Skill genBlood(int x, int y, Floor floor) {
		Skill newSkill = new Skill(x, y, floor);
		String name = "Offer Blood";
		int hpCost = 18;
		int mpCost = 0;
		int enCost = 0;
		int modifier = 75;
		AttackUp effect = new AttackUp(null, false, false);
		
		String desc = "Bloodletting ritual that strengthens next attack.";
		
		newSkill.setUp(name, hpCost, mpCost, enCost, effect, modifier);
		newSkill.setDesc(desc);
		
		return newSkill;
	}
	
	private static Skill genTeleport(int x, int y, Floor floor) {
		Skill newSkill = new Skill(x, y, floor);
		String name = "Teleport";
		int hpCost = 0;
		int mpCost = 10;
		int enCost = 2;
		int modifier = 0;
		Teleport effect = new Teleport(null);
		
		String desc = "Teleport to a random location.";
		
		newSkill.setUp(name, hpCost, mpCost, enCost, effect, modifier);
		newSkill.setDesc(desc);
		
		return newSkill;
	}
	
	private static Skill genHeal(int x, int y, Floor floor) {
		Skill newSkill = new Skill(x, y, floor);
		String name = "Bountiful Prayer";
		int hpCost = 0;
		int mpCost = 20;
		int enCost = 1;
		int modifier = 18;
		Heal effect = new Heal(null, false);
		
		String desc = "Heal for " + modifier + " hp.";
		
		newSkill.setUp(name, hpCost, mpCost, enCost, effect, modifier);
		newSkill.setDesc(desc);
		
		return newSkill;
	}
	
	private static Skill genRitual(int x, int y, Floor floor) {
		Skill newSkill = new Skill(x, y, floor);
		String name = "Profane Ritual";
		int hpCost = 20;
		int mpCost = 0;
		int enCost = 3;
		int modifier = 20;
		MpGain effect = new MpGain(null);
		
		String desc = "Forbidden ritual exchanges "+ modifier + " hp for mp.";
		
		newSkill.setUp(name, hpCost, mpCost, enCost, effect, modifier);
		newSkill.setDesc(desc);
		
		return newSkill;
	}
}
