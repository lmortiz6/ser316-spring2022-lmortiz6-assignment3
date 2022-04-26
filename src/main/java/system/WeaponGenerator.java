package main.java.system;

import main.java.object.Weapon;

public class WeaponGenerator {
	public static Weapon genWeapon(String name, int x, int y, int modifier) {
		switch (name.toLowerCase()) {
		case "dagger":
			return genDagger(modifier, x, y);
		case "shortsword":
			return genShortSword(modifier, x, y);
		case "longsword":
			return genLongSword(modifier, x, y);
		case "broadsword":
			return genBroadSword(modifier, x, y);
		case "spear":
			return genSpear(modifier, x, y);
		case "flail":
			return genFlail(modifier, x, y);
		case "hammer":
			return genHammer(modifier, x, y);
		case "caestus":
			return genCaestus(modifier, x, y);
		case "greatsword":
			return genGreatSword(modifier, x, y);
		default:
			return genDagger(modifier, x, y);
		}
	}
	
	private static Weapon genDagger(int modifier, int x, int y) {
		String name = "Dagger";
		if (modifier == 1) {
			name = "Poison " + name;
		}
		else if (modifier == 2) {
			name = "Jagged " + name;
		}
		else if (modifier == 3) {
			name = "Ancient " + name;
		}
		int damage = 7;
		if (modifier == 3) {
			damage *= 1.3;
		}
		int poison = 0;
		if (modifier == 1) {
			poison = 28;
		}
		int bleed = 0;
		if (modifier == 2) {
			bleed = 18;
		}
		int energyCost = 1;
		Hitbox hb = new Hitbox(1, 1);
		
		String desc = "Miniscule knife with short range and middling damage.";
		if (modifier == 1) {
			desc += " Inflicts poison.";
		}
		else if (modifier == 2) {
			desc += " Inflicts bleed.";
		}
		else if (modifier == 3) {
			desc += " Glows with ancient power";
		}
		
		Weapon newWeapon = new Weapon(x, y, Game.currentFloor);
		newWeapon.setUp(name, damage, poison, bleed, energyCost, hb);
		newWeapon.setDesc(desc);
		
		return newWeapon;
	}
	
	private static Weapon genShortSword(int modifier, int x, int y) {
		String name = "Short Sword";
		if (modifier == 1) {
			name = "Poison " + name;
		}
		else if (modifier == 2) {
			name = "Jagged " + name;
		}
		else if (modifier == 3) {
			name = "Ancient " + name;
		}
		
		int damage = 18;
		if (modifier == 3) {
			damage *= 1.3;
		}
		int poison = 0;
		if (modifier == 1) {
			poison = 28;
		}
		int bleed = 0;
		if (modifier == 2) {
			bleed = 18;
		}
		int energyCost = 2;
		Hitbox hb = new Hitbox(1, 1);
		
		String desc = "Small sword with short range.";
		if (modifier == 1) {
			desc += " Inflicts poison.";
		}
		else if (modifier == 2) {
			desc += " Inflicts bleed.";
		}
		else if (modifier == 3) {
			desc += " Glows with ancient power";
		}
		
		Weapon newWeapon = new Weapon(x, y, Game.currentFloor);
		newWeapon.setUp(name, damage, poison, bleed, energyCost, hb);
		newWeapon.setDesc(desc);
		
		return newWeapon;
	}
	
	private static Weapon genLongSword(int modifier, int x, int y) {
		String name = "Long Sword";
		if (modifier == 1) {
			name = "Poison " + name;
		}
		else if (modifier == 2) {
			name = "Jagged " + name;
		}
		else if (modifier == 3) {
			name = "Ancient " + name;
		}
		
		int damage = 24;
		if (modifier == 3) {
			damage *= 1.3;
		}
		int poison = 0;
		if (modifier == 1) {
			poison = 28;
		}
		int bleed = 0;
		if (modifier == 2) {
			bleed = 18;
		}
		int energyCost = 3;
		Hitbox hb = new Hitbox(1, 2);
		
		String desc = "Sword with long reach.";
		if (modifier == 1) {
			desc += " Inflicts poison.";
		}
		else if (modifier == 2) {
			desc += " Inflicts bleed.";
		}
		else if (modifier == 3) {
			desc += " Glows with ancient power";
		}
		
		Weapon newWeapon = new Weapon(x, y, Game.currentFloor);
		newWeapon.setUp(name, damage, poison, bleed, energyCost, hb);
		newWeapon.setDesc(desc);
		
		return newWeapon;
	}
	
	private static Weapon genBroadSword(int modifier, int x, int y) {
		String name = "Broad Sword";
		if (modifier == 1) {
			name = "Poison " + name;
		}
		else if (modifier == 2) {
			name = "Jagged " + name;
		}
		else if (modifier == 3) {
			name = "Ancient " + name;
		}
		
		int damage = 28;
		if (modifier == 3) {
			damage *= 1.3;
		}
		int poison = 0;
		if (modifier == 1) {
			poison = 28;
		}
		int bleed = 0;
		if (modifier == 2) {
			bleed = 18;
		}
		int energyCost = 3;
		Hitbox hb = new Hitbox(3, 1);
		
		String desc = "Sword with wide swing and high damage.";
		if (modifier == 1) {
			desc += " Inflicts poison.";
		}
		else if (modifier == 2) {
			desc += " Inflicts bleed.";
		}
		else if (modifier == 3) {
			desc += " Glows with ancient power";
		}
		
		Weapon newWeapon = new Weapon(x, y, Game.currentFloor);
		newWeapon.setUp(name, damage, poison, bleed, energyCost, hb);
		newWeapon.setDesc(desc);
		
		return newWeapon;
	}
	
	private static Weapon genSpear(int modifier, int x, int y) {
		String name = "Spear";
		if (modifier == 1) {
			name = "Poison " + name;
		}
		else if (modifier == 2) {
			name = "Jagged " + name;
		}
		else if (modifier == 3) {
			name = "Ancient " + name;
		}
		
		int damage = 18;
		if (modifier == 3) {
			damage *= 1.3;
		}
		int poison = 0;
		if (modifier == 1) {
			poison = 28;
		}
		int bleed = 0;
		if (modifier == 2) {
			bleed = 18;
		}
		int energyCost = 3;
		Hitbox hb = new Hitbox(1, 3);
		
		String desc = "Polearm with very long range.";
		if (modifier == 1) {
			desc += " Inflicts poison.";
		}
		else if (modifier == 2) {
			desc += " Inflicts bleed.";
		}
		else if (modifier == 3) {
			desc += " Glows with ancient power";
		}
		
		Weapon newWeapon = new Weapon(x, y, Game.currentFloor);
		newWeapon.setUp(name, damage, poison, bleed, energyCost, hb);
		newWeapon.setDesc(desc);
		
		return newWeapon;
	}
	
	private static Weapon genFlail(int modifier, int x, int y) {
		String name = "Flail";
		if (modifier == 1) {
			name = "Poison " + name;
		}
		else if (modifier == 2) {
			name = "Jagged " + name;
		}
		else if (modifier == 3) {
			name = "Ancient " + name;
		}
		
		int damage = 15;
		if (modifier == 3) {
			damage *= 1.3;
		}
		int poison = 0;
		if (modifier == 1) {
			poison = 28;
		}
		int bleed = 0;
		if (modifier == 2) {
			bleed = 18;
		}
		int energyCost = 2;
		Hitbox hb = new Hitbox(3, 1);
		
		String desc = "Flail with wide swing and meager damage.";
		if (modifier == 1) {
			desc += " Inflicts poison.";
		}
		else if (modifier == 2) {
			desc += " Inflicts bleed.";
		}
		else if (modifier == 3) {
			desc += " Glows with ancient power";
		}
		
		Weapon newWeapon = new Weapon(x, y, Game.currentFloor);
		newWeapon.setUp(name, damage, poison, bleed, energyCost, hb);
		newWeapon.setDesc(desc);
		
		return newWeapon;
	}
	
	private static Weapon genHammer(int modifier, int x, int y) {
		String name = "Hammer";
		if (modifier == 3 || modifier == 2) {
			name = "Ancient " + name;
		}
		
		int damage = 34;
		if (modifier == 3) {
			damage *= 1.3;
		}
		int poison = 0;
		if (modifier == 1) {
			poison = 28;
		}
		int bleed = 0;
		if (modifier == 2) {
			bleed = 18;
		}
		int energyCost = 3;
		Hitbox hb = new Hitbox(1, 1);
		
		String desc = "Hammer with short range and immense damage.";
		if (modifier == 3) {
			desc += " Glows with ancient power";
		}
		
		Weapon newWeapon = new Weapon(x, y, Game.currentFloor);
		newWeapon.setUp(name, damage, poison, bleed, energyCost, hb);
		newWeapon.setDesc(desc);
		
		return newWeapon;
	}
	
	private static Weapon genCaestus(int modifier, int x, int y) {
		String name = "Caestus";
		if (modifier == 3) {
			name = "Ancient " + name;
		}
		
		int damage = 13;
		if (modifier == 3) {
			damage *= 1.3;
		}
		int poison = 0;
		if (modifier == 1) {
			poison = 28;
		}
		int bleed = 0;
		if (modifier == 2) {
			bleed = 18;
		}
		int energyCost = 1;
		Hitbox hb = new Hitbox(1, 1);
		
		String desc = "Short range fist weapon with meager damage.";
		if (modifier == 3) {
			desc += " Glows with ancient power";
		}
		
		Weapon newWeapon = new Weapon(x, y, Game.currentFloor);
		newWeapon.setUp(name, damage, poison, bleed, energyCost, hb);
		newWeapon.setDesc(desc);
		
		return newWeapon;
	}
	
	private static Weapon genGreatSword(int modifier, int x, int y) {
		String name = "Great Sword";
		if (modifier == 1) {
			name = "Poison " + name;
		}
		else if (modifier == 2) {
			name = "Jagged " + name;
		}
		else if (modifier == 3) {
			name = "Ancient " + name;
		}
		
		int damage = 32;
		if (modifier == 3) {
			damage *= 1.3;
		}
		int poison = 0;
		if (modifier == 1) {
			poison = 28;
		}
		int bleed = 0;
		if (modifier == 2) {
			bleed = 18;
		}
		int energyCost = 4;
		Hitbox hb = new Hitbox(3, 2);
		
		String desc = "Heap of raw iron. Massive range and damage.";
		if (modifier == 1) {
			desc += " Inflicts poison.";
		}
		else if (modifier == 2) {
			desc += " Inflicts bleed.";
		}
		else if (modifier == 3) {
			desc += " Glows with ancient power";
		}
		
		Weapon newWeapon = new Weapon(x, y, Game.currentFloor);
		newWeapon.setUp(name, damage, poison, bleed, energyCost, hb);
		newWeapon.setDesc(desc);
		
		return newWeapon;
	}
}
