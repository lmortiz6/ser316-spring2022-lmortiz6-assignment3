package main.java.system;

import main.java.object.LevelUp;
import main.java.object.Player;
import main.java.object.Skill;
import main.java.object.UseItem;
import main.java.object.Weapon;

public class PlayerGenerator {
	
	public static Player genPlayer(String name, int type) {
		switch (type) {
		case 0:
			return genWarrior(name);
		case 1:
			return genThief(name);
		case 2:
			return genMage(name);
		default:
			return genWarrior(name);
		}
	}
	
	private static Player genWarrior(String name) {
		Player newPlayer = new Player(0, 0, null);
		
		Weapon weapon = WeaponGenerator.genWeapon("longsword", 0, 0, null, 0);
		newPlayer.addItem(weapon);
		weapon.setOwner(newPlayer);
		newPlayer.equipWeapon(weapon);
		Skill level = new LevelUp(0, 0, null);
		newPlayer.addItem(level);
		level.setOwner(newPlayer);
		Skill skill1 = SkillGenerator.genSkill("heal", 0, 0, null);
		newPlayer.addItem(skill1);
		skill1.setOwner(newPlayer);
		UseItem useItem1 = UseItemGenerator.genUseItem("hppotion", 0, 0, null, 40);
		newPlayer.addItem(useItem1);
		useItem1.setOwner(newPlayer);
		
		int vig = 13;
		int mnd = 8;
		int end = 10;
		int str = 12;
		int lck = 9;
		
		newPlayer.setUp(name, '@', 100, 100, 4, 0, vig, mnd, end, str, lck, null);
		return newPlayer;
	}
	
	private static Player genThief(String name) {
		Player newPlayer = new Player(0, 0, null);
		
		Weapon weapon = WeaponGenerator.genWeapon("dagger", 0, 0, null, 2);
		newPlayer.addItem(weapon);
		weapon.setOwner(newPlayer);
		newPlayer.equipWeapon(weapon);
		Skill level = new LevelUp(0, 0, null);
		newPlayer.addItem(level);
		level.setOwner(newPlayer);
		UseItem useItem1 = UseItemGenerator.genUseItem("enpotion", 0, 0, null, 4);
		newPlayer.addItem(useItem1);
		useItem1.setOwner(newPlayer);
		UseItem useItem2 = UseItemGenerator.genUseItem("teleport", 0, 0, null, 1);
		newPlayer.addItem(useItem2);
		useItem2.setOwner(newPlayer);
		
		int vig = 9;
		int mnd = 9;
		int end = 13;
		int str = 9;
		int lck = 13;
		
		newPlayer.setUp(name, '@', 100, 100, 4, 0, vig, mnd, end, str, lck, null);
		return newPlayer;
	}
	
	private static Player genMage(String name) {
		Player newPlayer = new Player(0, 0, null);
		
		Weapon weapon = WeaponGenerator.genWeapon("shortsword", 0, 0, null, 0);
		newPlayer.addItem(weapon);
		weapon.setOwner(newPlayer);
		newPlayer.equipWeapon(weapon);
		Skill level = new LevelUp(0, 0, null);
		newPlayer.addItem(level);
		level.setOwner(newPlayer);
		Skill skill1 = SkillGenerator.genSkill("spark", 0, 0, null);
		newPlayer.addItem(skill1);
		skill1.setOwner(newPlayer);
		Skill skill2 = SkillGenerator.genSkill("fireball", 0, 0, null);
		newPlayer.addItem(skill2);
		skill2.setOwner(newPlayer);
		UseItem useItem1 = UseItemGenerator.genUseItem("mppotion", 0, 0, null, 40);
		newPlayer.addItem(useItem1);
		useItem1.setOwner(newPlayer);
		UseItem useItem2 = UseItemGenerator.genUseItem("mppotion", 0, 0, null, 40);
		newPlayer.addItem(useItem2);
		useItem2.setOwner(newPlayer);
		
		int vig = 7;
		int mnd = 16;
		int end = 10;
		int str = 7;
		int lck = 11;
		
		newPlayer.setUp(name, '@', 100, 100, 4, 0, vig, mnd, end, str, lck, null);
		return newPlayer;
	}
}
