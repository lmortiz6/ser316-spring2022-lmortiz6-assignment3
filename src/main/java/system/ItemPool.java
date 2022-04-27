/**
 * 
 * The pool classes use the strategy pattern to make specific calls to Generators at runtime.
 * Method calls are encapsulated into anonymous classes, which are stored in an arraylist so that they can be pulled randomly.
 * 
 */

package main.java.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import main.java.object.Item;

public class ItemPool {
	
	private static HashMap<String, ArrayList<Command>> pools;
	private static ArrayList<Command> floor1_2;
	private static ArrayList<Command> floor3_5;
	private static ArrayList<Command> treasure;
	private static ArrayList<Command> elite;
	private static ArrayList<Command> curse;
	private static Random rng;
	
	static {
		rng = Game.levelrng;
		pools = new HashMap<String, ArrayList<Command>>();
		
		floor1_2 = new ArrayList<Command>();
		floor1_2.add(new Command() { @Override
			public Item get(int x, int y, Floor floor) { return UseItemGenerator.genUseItem("hppotion", x, y, floor, 40);}});
		floor1_2.add(new Command() { @Override
			public Item get(int x, int y, Floor floor) { return UseItemGenerator.genUseItem("mppotion", x, y, floor, 40);}});
		floor1_2.add(new Command() { @Override
			public Item get(int x, int y, Floor floor) { return UseItemGenerator.genUseItem("enpotion", x, y, floor, 2);}});
		floor1_2.add(new Command() { @Override
			public Item get(int x, int y, Floor floor) { return UseItemGenerator.genUseItem("antidote", x, y, floor, 1);}});
		floor1_2.add(new Command() { @Override
			public Item get(int x, int y, Floor floor) { return UseItemGenerator.genUseItem("savingthrow", x, y, floor, 5);}});
		floor1_2.add(new Command() { @Override
			public Item get(int x, int y, Floor floor) { return UseItemGenerator.genUseItem("teleport", x, y, floor, 1);}});
		floor1_2.add(new Command() { @Override
			public Item get(int x, int y, Floor floor) { return WeaponGenerator.genWeapon("dagger", x, y, floor, rng.nextInt(4));}});
		floor1_2.add(new Command() { @Override
			public Item get(int x, int y, Floor floor) { return WeaponGenerator.genWeapon("shortsword", x, y, floor, rng.nextInt(4));}});
		floor1_2.add(new Command() { @Override
			public Item get(int x, int y, Floor floor) { return WeaponGenerator.genWeapon("flail", x, y, floor, rng.nextInt(4));}});
		floor1_2.add(new Command() { @Override
			public Item get(int x, int y, Floor floor) { return WeaponGenerator.genWeapon("longsword", x, y, floor, rng.nextInt(4));}});
		floor1_2.add(new Command() { @Override
			public Item get(int x, int y, Floor floor) { return SkillGenerator.genSkill("spark", x, y, floor);}});
		floor1_2.add(new Command() { @Override
			public Item get(int x, int y, Floor floor) { return SkillGenerator.genSkill("fireball", x, y, floor);}});
		floor1_2.add(new Command() { @Override
			public Item get(int x, int y, Floor floor) { return SkillGenerator.genSkill("teleport", x, y, floor);}});
		floor1_2.add(new Command() { @Override
			public Item get(int x, int y, Floor floor) { return SkillGenerator.genSkill("heal", x, y, floor);}});
		
		floor3_5 = new ArrayList<Command>(floor1_2);
		floor3_5.add(new Command() { @Override
			public Item get(int x, int y, Floor floor) { return UseItemGenerator.genUseItem("thorns", x, y, floor, 1);}});
		floor3_5.add(new Command() { @Override
			public Item get(int x, int y, Floor floor) { return UseItemGenerator.genUseItem("attackup", x, y, floor, 1);}});
		floor3_5.add(new Command() { @Override
			public Item get(int x, int y, Floor floor) { return WeaponGenerator.genWeapon("broadsword", x, y, floor, rng.nextInt(4));}});
		floor3_5.add(new Command() { @Override
			public Item get(int x, int y, Floor floor) { return WeaponGenerator.genWeapon("spear", x, y, floor, rng.nextInt(4));}});
		floor3_5.add(new Command() { @Override
			public Item get(int x, int y, Floor floor) { return WeaponGenerator.genWeapon("hammer", x, y, floor, rng.nextInt(3));}});
		floor3_5.add(new Command() { @Override
			public Item get(int x, int y, Floor floor) { return WeaponGenerator.genWeapon("caestus", x, y, floor, rng.nextInt(4));}});
		floor3_5.add(new Command() { @Override
			public Item get(int x, int y, Floor floor) { return SkillGenerator.genSkill("poison", x, y, floor);}});
		floor3_5.add(new Command() { @Override
			public Item get(int x, int y, Floor floor) { return SkillGenerator.genSkill("lightning", x, y, floor);}});
		
		treasure = new ArrayList<Command>();
		treasure.add(new Command() { @Override
			public Item get(int x, int y, Floor floor) { return SkillGenerator.genSkill("fireball", x, y, floor);}});
		treasure.add(new Command() { @Override
			public Item get(int x, int y, Floor floor) { return SkillGenerator.genSkill("heal", x, y, floor);}});
		treasure.add(new Command() { @Override
			public Item get(int x, int y, Floor floor) { return SkillGenerator.genSkill("lightning", x, y, floor);}});
		treasure.add(new Command() { @Override
			public Item get(int x, int y, Floor floor) { return SkillGenerator.genSkill("boulder", x, y, floor);}});
		treasure.add(new Command() { @Override
			public Item get(int x, int y, Floor floor) { return SkillGenerator.genSkill("blood", x, y, floor);}});
		treasure.add(new Command() { @Override
			public Item get(int x, int y, Floor floor) { return SkillGenerator.genSkill("ritual", x, y, floor);}});
		treasure.add(new Command() { @Override
			public Item get(int x, int y, Floor floor) { return RelicGenerator.genRelic("thorns", x, y, floor);}});
		treasure.add(new Command() { @Override
			public Item get(int x, int y, Floor floor) { return RelicGenerator.genRelic("vampire", x, y, floor);}});
		treasure.add(new Command() { @Override
			public Item get(int x, int y, Floor floor) { return RelicGenerator.genRelic("vessel", x, y, floor);}});
		treasure.add(new Command() { @Override
			public Item get(int x, int y, Floor floor) { return RelicGenerator.genRelic("bracer", x, y, floor);}});
		treasure.add(new Command() { @Override
			public Item get(int x, int y, Floor floor) { return RelicGenerator.genRelic("crown", x, y, floor);}});
		treasure.add(new Command() { @Override
			public Item get(int x, int y, Floor floor) { return RelicGenerator.genRelic("transfusion", x, y, floor);}});
		treasure.add(new Command() { @Override
			public Item get(int x, int y, Floor floor) { return RelicGenerator.genRelic("flesh", x, y, floor);}});
		treasure.add(new Command() { @Override
			public Item get(int x, int y, Floor floor) { return RelicGenerator.genRelic("crystal", x, y, floor);}});
		treasure.add(new Command() { @Override
			public Item get(int x, int y, Floor floor) { return RelicGenerator.genRelic("iron", x, y, floor);}});
		
		elite = new ArrayList<Command>(treasure);
		elite.add(new Command() { @Override
			public Item get(int x, int y, Floor floor) { return WeaponGenerator.genWeapon("broadsword", x, y, floor, 3);}});
		elite.add(new Command() { @Override
			public Item get(int x, int y, Floor floor) { return WeaponGenerator.genWeapon("spear", x, y, floor, 3);}});
		elite.add(new Command() { @Override
			public Item get(int x, int y, Floor floor) { return WeaponGenerator.genWeapon("hammer", x, y, floor, 3);}});
		elite.add(new Command() { @Override
			public Item get(int x, int y, Floor floor) { return WeaponGenerator.genWeapon("greatsword", x, y, floor, 3);}});
		
		curse = new ArrayList<Command>();
		curse.add(new Command() { @Override
			public Item get(int x, int y, Floor floor) { return RelicGenerator.genRelic("shackles", x, y, floor);}});
		curse.add(new Command() { @Override
			public Item get(int x, int y, Floor floor) { return RelicGenerator.genRelic("pupil", x, y, floor);}});
		curse.add(new Command() { @Override
			public Item get(int x, int y, Floor floor) { return RelicGenerator.genRelic("bane", x, y, floor);}});
		curse.add(new Command() { @Override
			public Item get(int x, int y, Floor floor) { return RelicGenerator.genRelic("heart", x, y, floor);}});
		curse.add(new Command() { @Override
			public Item get(int x, int y, Floor floor) { return RelicGenerator.genRelic("spirit", x, y, floor);}});
		
		pools.put("1", floor1_2);
		pools.put("2", floor1_2);
		pools.put("3", floor3_5);
		pools.put("4", floor3_5);
		pools.put("5", floor3_5);
		pools.put("treasure", treasure);
		pools.put("elite", elite);
		pools.put("curse", curse);
	}
	
	public static Item pull(String pool, int x, int y, Floor floor) {
		return pull(pools.get(pool), x, y, floor);
	}
	
	private static Item pull(ArrayList<Command> pool, int x, int y, Floor floor) {
		int num = rng.nextInt(pool.size());
		return pool.get(num).get(x, y, floor);
	}
	
	private interface Command {
		public Item get(int x, int y, Floor floor);
	}
}
