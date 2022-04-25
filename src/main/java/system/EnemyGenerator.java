package main.java.system;

import main.java.object.Enemy;
import main.java.object.Item;
import main.java.object.Weapon;

public class EnemyGenerator {

	public static Enemy genEnemy(String name, int x, int y) {
		switch (name.toLowerCase()) {
		case "imp":
			return genImp(x, y);
		case "goblin":
			return genGoblin(x, y);
		case "lich":
			return genLich(x, y);
		case "beastman":
			return genBeastman(x, y);
		case "skeleton":
			return genSkeleton(x, y);
		case "mindflayer":
			return genMindflayer(x, y);
		case "werewolf":
			return genWerewolf(x, y);
		case "deepone":
			return genDeepone(x, y);
		case "hero":
			return genHero(x, y);
		case "cerberus":
			return genCerberus(x, y);
		case "minotaur":
			return genMinotaur(x, y);
		default:
			return genImp(x, y);
		}
	}
	
	private static Enemy genImp(int x, int y) {
		Weapon weapon = WeaponGenerator.genWeapon("dagger", 2, x, y);
		BasicAi ai = new BasicAi();
    	Enemy newEnemy = new Enemy(x, y, Game.currentFloor, ai);
    	ai.setOwner(newEnemy);
    	newEnemy.equipWeapon(weapon);
    	
    	String name = "Imp";
    	char ascii = name.toLowerCase().charAt(0);
    	int hp = 25;
    	int mp = 22;
    	int en = 3;
    	int xp = 20;
    	int vig = 10;
    	int mnd = 10;
    	int end = 10;
    	int str = 8;
    	int lck = 10;
    	Item item = null; // draw from pool
    	
    	newEnemy.setUp(name, ascii, hp, mp, en, xp, vig, mnd, end, str, lck, item);
    	
    	return newEnemy;
	}
	
	private static Enemy genGoblin(int x, int y) {
		Weapon weapon = WeaponGenerator.genWeapon("shortsword", 0, x, y);
		BasicAi ai = new BasicAi();
    	Enemy newEnemy = new Enemy(x, y, Game.currentFloor, ai);
    	ai.setOwner(newEnemy);
    	newEnemy.equipWeapon(weapon);
    	
    	String name = "Goblin";
    	char ascii = name.toLowerCase().charAt(0);
    	int hp = 35;
    	int mp = 30;
    	int en = 4;
    	int xp = 27;
    	int vig = 10;
    	int mnd = 10;
    	int end = 10;
    	int str = 9;
    	int lck = 9;
    	Item item = null; // draw from pool
    	
    	newEnemy.setUp(name, ascii, hp, mp, en, xp, vig, mnd, end, str, lck, item);
    	
    	return newEnemy;
	}
	
	private static Enemy genLich(int x, int y) {
		Weapon weapon = WeaponGenerator.genWeapon("hammer", 0, x, y);
		BasicAi ai = new BasicAi();
    	Enemy newEnemy = new Enemy(x, y, Game.currentFloor, ai);
    	ai.setOwner(newEnemy);
    	newEnemy.equipWeapon(weapon);
    	
    	String name = "Lich";
    	char ascii = name.toLowerCase().charAt(0);
    	int hp = 25;
    	int mp = 20;
    	int en = 3;
    	int xp = 33;
    	int vig = 10;
    	int mnd = 10;
    	int end = 10;
    	int str = 10;
    	int lck = 6;
    	Item item = null; // draw from pool
    	
    	newEnemy.setUp(name, ascii, hp, mp, en, xp, vig, mnd, end, str, lck, item);
    	
    	return newEnemy;
	}
	
	private static Enemy genBeastman(int x, int y) {
		Weapon weapon = WeaponGenerator.genWeapon("flail", 1, x, y);
		BasicAi ai = new BasicAi();
    	Enemy newEnemy = new Enemy(x, y, Game.currentFloor, ai);
    	ai.setOwner(newEnemy);
    	newEnemy.equipWeapon(weapon);
    	
    	String name = "Beastman";
    	char ascii = name.toLowerCase().charAt(0);
    	int hp = 28;
    	int mp = 10;
    	int en = 6;
    	int xp = 40;
    	int vig = 10;
    	int mnd = 10;
    	int end = 10;
    	int str = 8;
    	int lck = 12;
    	Item item = null; // draw from pool
    	
    	newEnemy.setUp(name, ascii, hp, mp, en, xp, vig, mnd, end, str, lck, item);
    	
    	return newEnemy;
	}
	
	private static Enemy genSkeleton(int x, int y) {
		Weapon weapon = WeaponGenerator.genWeapon("spear", 2, x, y);
		BasicAi ai = new BasicAi();
    	Enemy newEnemy = new Enemy(x, y, Game.currentFloor, ai);
    	ai.setOwner(newEnemy);
    	newEnemy.equipWeapon(weapon);
    	
    	String name = "Skeleton";
    	char ascii = name.toLowerCase().charAt(0);
    	int hp = 20;
    	int mp = 20;
    	int en = 6;
    	int xp = 40;
    	int vig = 10;
    	int mnd = 10;
    	int end = 10;
    	int str = 12;
    	int lck = 11;
    	Item item = null; // draw from pool
    	
    	newEnemy.setUp(name, ascii, hp, mp, en, xp, vig, mnd, end, str, lck, item);
    	
    	return newEnemy;
	}
	
	private static Enemy genMindflayer(int x, int y) {
		Weapon weapon = WeaponGenerator.genWeapon("shortsword", 3, x, y);
		BasicAi ai = new BasicAi();
    	Enemy newEnemy = new Enemy(x, y, Game.currentFloor, ai);
    	ai.setOwner(newEnemy);
    	newEnemy.equipWeapon(weapon);
    	
    	String name = "Mind Flayer";
    	char ascii = name.toLowerCase().charAt(0);
    	int hp = 40;
    	int mp = 50;
    	int en = 4;
    	int xp = 50;
    	int vig = 10;
    	int mnd = 10;
    	int end = 10;
    	int str = 13;
    	int lck = 7;
    	Item item = null; // draw from pool
    	
    	newEnemy.setUp(name, ascii, hp, mp, en, xp, vig, mnd, end, str, lck, item);
    	
    	return newEnemy;
	}
	
	private static Enemy genWerewolf(int x, int y) {
		Weapon weapon = WeaponGenerator.genWeapon("caestus", 3, x, y);
		BasicAi ai = new BasicAi();
    	Enemy newEnemy = new Enemy(x, y, Game.currentFloor, ai);
    	ai.setOwner(newEnemy);
    	newEnemy.equipWeapon(weapon);
    	
    	String name = "Werewolf";
    	char ascii = name.charAt(0);
    	int hp = 50;
    	int mp = 50;
    	int en = 5;
    	int xp = 110;
    	int vig = 10;
    	int mnd = 10;
    	int end = 10;
    	int str = 14;
    	int lck = 10;
    	Item item = null; // draw from pool
    	
    	newEnemy.setUp(name, ascii, hp, mp, en, xp, vig, mnd, end, str, lck, item);
    	
    	return newEnemy;
	}
	
	private static Enemy genDeepone(int x, int y) {
		Weapon weapon = WeaponGenerator.genWeapon("flail", 1, x, y);
		BasicAi ai = new BasicAi();
    	Enemy newEnemy = new Enemy(x, y, Game.currentFloor, ai);
    	ai.setOwner(newEnemy);
    	newEnemy.equipWeapon(weapon);
    	
    	String name = "Deep One";
    	char ascii = name.charAt(0);
    	int hp = 60;
    	int mp = 60;
    	int en = 8;
    	int xp = 110;
    	int vig = 10;
    	int mnd = 10;
    	int end = 10;
    	int str = 6;
    	int lck = 9;
    	Item item = null; // draw from pool
    	
    	newEnemy.setUp(name, ascii, hp, mp, en, xp, vig, mnd, end, str, lck, item);
    	
    	return newEnemy;
	}
	
	private static Enemy genHero(int x, int y) {
		Weapon weapon = WeaponGenerator.genWeapon("greatsword", 3, x, y);
		BasicAi ai = new BasicAi();
    	Enemy newEnemy = new Enemy(x, y, Game.currentFloor, ai);
    	ai.setOwner(newEnemy);
    	newEnemy.equipWeapon(weapon);
    	
    	String name = "Hero of Legend";
    	char ascii = name.charAt(0);
    	int hp = 60;
    	int mp = 60;
    	int en = 6;
    	int xp = 120;
    	int vig = 10;
    	int mnd = 10;
    	int end = 10;
    	int str = 11;
    	int lck = 12;
    	Item item = null; // draw from pool
    	
    	newEnemy.setUp(name, ascii, hp, mp, en, xp, vig, mnd, end, str, lck, item);
    	
    	return newEnemy;
	}
	
	private static Enemy genCerberus(int x, int y) {
		Weapon weapon = WeaponGenerator.genWeapon("dagger", 2, x, y);
		BasicAi ai = new BasicAi();
    	Enemy newEnemy = new Enemy(x, y, Game.currentFloor, ai);
    	ai.setOwner(newEnemy);
    	newEnemy.equipWeapon(weapon);
    	
    	String name = "Cerberus";
    	char ascii = name.charAt(0);
    	int hp = 70;
    	int mp = 10;
    	int en = 5;
    	int xp = 120;
    	int vig = 10;
    	int mnd = 10;
    	int end = 10;
    	int str = 12;
    	int lck = 10;
    	Item item = null; // draw from pool
    	
    	newEnemy.setUp(name, ascii, hp, mp, en, xp, vig, mnd, end, str, lck, item);
    	
    	return newEnemy;
	}
	
	private static Enemy genMinotaur(int x, int y) {
		Weapon weapon = WeaponGenerator.genWeapon("hammer", 3, x, y);
		BasicAi ai = new BasicAi();
    	Enemy newEnemy = new Enemy(x, y, Game.currentFloor, ai);
    	ai.setOwner(newEnemy);
    	newEnemy.equipWeapon(weapon);
    	
    	String name = "Minotaur";
    	char ascii = name.charAt(0);
    	int hp = 70;
    	int mp = 50;
    	int en = 4;
    	int xp = 120;
    	int vig = 10;
    	int mnd = 10;
    	int end = 10;
    	int str = 12;
    	int lck = 9;
    	Item item = null; // draw from pool
    	
    	newEnemy.setUp(name, ascii, hp, mp, en, xp, vig, mnd, end, str, lck, item);
    	
    	return newEnemy;
	}
}
