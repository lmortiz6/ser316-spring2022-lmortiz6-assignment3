package main.java.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import main.java.object.Item;

public class ItemPool {
	
	private static HashMap<String, ArrayList<Command>> pools;
	private static ArrayList<Command> floor1_2;
	private static ArrayList<Command> floor3_5;
	//private static ArrayList<Command> shop;
	private static ArrayList<Command> treasure;
	//private static ArrayList<Command> enemy;
	private static ArrayList<Command> elite;
	private static ArrayList<Command> curse;
	private static Random rng;
	
	static {
		rng = Game.levelrng;
		pools = new HashMap<String, ArrayList<Command>>();
		floor1_2 = new ArrayList<Command>();
		floor1_2.add(new Command() { @Override
			public Item get(int x, int y) { return UseItemGenerator.genUseItem("hppotion", x, y, 40);}});
		floor1_2.add(new Command() { @Override
			public Item get(int x, int y) { return UseItemGenerator.genUseItem("mppotion", x, y, 40);}});
		floor1_2.add(new Command() { @Override
			public Item get(int x, int y) { return UseItemGenerator.genUseItem("enpotion", x, y, 2);}});
		floor1_2.add(new Command() { @Override
			public Item get(int x, int y) { return UseItemGenerator.genUseItem("antidote", x, y, 1);}});
		floor1_2.add(new Command() { @Override
			public Item get(int x, int y) { return UseItemGenerator.genUseItem("savingthrow", x, y, 5);}});
		floor1_2.add(new Command() { @Override
			public Item get(int x, int y) { return UseItemGenerator.genUseItem("teleport", x, y, 1);}});
		floor1_2.add(new Command() { @Override
			public Item get(int x, int y) { return WeaponGenerator.genWeapon("dagger", x, y, rng.nextInt(4));}});
		floor1_2.add(new Command() { @Override
			public Item get(int x, int y) { return WeaponGenerator.genWeapon("shortsword", x, y, rng.nextInt(4));}});
		floor1_2.add(new Command() { @Override
			public Item get(int x, int y) { return WeaponGenerator.genWeapon("flail", x, y, rng.nextInt(4));}});
		floor1_2.add(new Command() { @Override
			public Item get(int x, int y) { return WeaponGenerator.genWeapon("longsword", x, y, rng.nextInt(4));}});
		floor1_2.add(new Command() { @Override
			public Item get(int x, int y) { return SkillGenerator.genSkill("spark", x, y);}});
		floor1_2.add(new Command() { @Override
			public Item get(int x, int y) { return SkillGenerator.genSkill("fireball", x, y);}});
		floor1_2.add(new Command() { @Override
			public Item get(int x, int y) { return SkillGenerator.genSkill("teleport", x, y);}});
		floor1_2.add(new Command() { @Override
			public Item get(int x, int y) { return SkillGenerator.genSkill("heal", x, y);}});
		
		floor3_5 = new ArrayList<Command>(floor1_2);
		floor3_5.add(new Command() { @Override
			public Item get(int x, int y) { return UseItemGenerator.genUseItem("thorns", x, y, 1);}});
		floor3_5.add(new Command() { @Override
			public Item get(int x, int y) { return UseItemGenerator.genUseItem("attackup", x, y, 1);}});
		floor3_5.add(new Command() { @Override
			public Item get(int x, int y) { return WeaponGenerator.genWeapon("broadsword", x, y, rng.nextInt(4));}});
		floor3_5.add(new Command() { @Override
			public Item get(int x, int y) { return WeaponGenerator.genWeapon("spear", x, y, rng.nextInt(4));}});
		floor3_5.add(new Command() { @Override
			public Item get(int x, int y) { return WeaponGenerator.genWeapon("hammer", x, y, rng.nextInt(3));}});
		floor3_5.add(new Command() { @Override
			public Item get(int x, int y) { return WeaponGenerator.genWeapon("caestus", x, y, rng.nextInt(4));}});
		floor3_5.add(new Command() { @Override
			public Item get(int x, int y) { return SkillGenerator.genSkill("poison", x, y);}});
		floor3_5.add(new Command() { @Override
			public Item get(int x, int y) { return SkillGenerator.genSkill("lightning", x, y);}});
		
		treasure = new ArrayList<Command>();
		treasure.add(new Command() { @Override
			public Item get(int x, int y) { return SkillGenerator.genSkill("fireball", x, y);}});
		treasure.add(new Command() { @Override
			public Item get(int x, int y) { return SkillGenerator.genSkill("heal", x, y);}});
		treasure.add(new Command() { @Override
			public Item get(int x, int y) { return SkillGenerator.genSkill("lightning", x, y);}});
		treasure.add(new Command() { @Override
			public Item get(int x, int y) { return SkillGenerator.genSkill("boulder", x, y);}});
		treasure.add(new Command() { @Override
			public Item get(int x, int y) { return SkillGenerator.genSkill("blood", x, y);}});
		treasure.add(new Command() { @Override
			public Item get(int x, int y) { return SkillGenerator.genSkill("ritual", x, y);}});
		treasure.add(new Command() { @Override
			public Item get(int x, int y) { return RelicGenerator.genRelic("thorns", x, y);}});
		treasure.add(new Command() { @Override
			public Item get(int x, int y) { return RelicGenerator.genRelic("vampire", x, y);}});
		treasure.add(new Command() { @Override
			public Item get(int x, int y) { return RelicGenerator.genRelic("vessel", x, y);}});
		treasure.add(new Command() { @Override
			public Item get(int x, int y) { return RelicGenerator.genRelic("bracer", x, y);}});
		treasure.add(new Command() { @Override
			public Item get(int x, int y) { return RelicGenerator.genRelic("crown", x, y);}});
		treasure.add(new Command() { @Override
			public Item get(int x, int y) { return RelicGenerator.genRelic("transfusion", x, y);}});
		treasure.add(new Command() { @Override
			public Item get(int x, int y) { return RelicGenerator.genRelic("flesh", x, y);}});
		treasure.add(new Command() { @Override
			public Item get(int x, int y) { return RelicGenerator.genRelic("crystal", x, y);}});
		treasure.add(new Command() { @Override
			public Item get(int x, int y) { return RelicGenerator.genRelic("iron", x, y);}});
		
		elite = new ArrayList<Command>(treasure);
		elite.add(new Command() { @Override
			public Item get(int x, int y) { return WeaponGenerator.genWeapon("broadsword", x, y, 3);}});
		elite.add(new Command() { @Override
			public Item get(int x, int y) { return WeaponGenerator.genWeapon("spear", x, y, 3);}});
		elite.add(new Command() { @Override
			public Item get(int x, int y) { return WeaponGenerator.genWeapon("hammer", x, y, 3);}});
		elite.add(new Command() { @Override
			public Item get(int x, int y) { return WeaponGenerator.genWeapon("greatsword", x, y, 3);}});
		
		curse = new ArrayList<Command>();
		curse.add(new Command() { @Override
			public Item get(int x, int y) { return RelicGenerator.genRelic("shackles", x, y);}});
		curse.add(new Command() { @Override
			public Item get(int x, int y) { return RelicGenerator.genRelic("pupil", x, y);}});
		curse.add(new Command() { @Override
			public Item get(int x, int y) { return RelicGenerator.genRelic("bane", x, y);}});
		curse.add(new Command() { @Override
			public Item get(int x, int y) { return RelicGenerator.genRelic("heart", x, y);}});
		curse.add(new Command() { @Override
			public Item get(int x, int y) { return RelicGenerator.genRelic("spirit", x, y);}});
		
		pools.put("1", floor1_2);
		pools.put("2", floor1_2);
		pools.put("3", floor3_5);
		pools.put("4", floor3_5);
		pools.put("5", floor3_5);
		pools.put("treasure", treasure);
		pools.put("elite", elite);
		pools.put("curse", curse);
	}
	
	public static Item pull(String pool, int x, int y) {
		return pull(pools.get(pool), x, y);
	}
	
	private static Item pull(ArrayList<Command> pool, int x, int y) {
		int num = rng.nextInt(pool.size());
		return pool.get(num).get(x, y);
	}
	
	private interface Command {
		public Item get(int x, int y);
	}
}
