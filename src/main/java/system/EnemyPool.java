package main.java.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import main.java.object.Enemy;

public class EnemyPool {
	
	private static HashMap<String, ArrayList<Command>> pools;
	private static ArrayList<Command> floor1_2;
	private static ArrayList<Command> floor3_5;
	private static ArrayList<Command> elite;
	private static ArrayList<Command> boss;
	private static Random rng;
	
	static {
		rng = Game.levelrng;
		pools = new HashMap<String, ArrayList<Command>>();
		
		floor1_2 = new ArrayList<Command>();
		floor1_2.add(new Command() { @Override
			public Enemy get(int x, int y, Floor floor) { return EnemyGenerator.genEnemy("imp", x, y, floor);}});
		floor1_2.add(new Command() { @Override
			public Enemy get(int x, int y, Floor floor) { return EnemyGenerator.genEnemy("goblin", x, y, floor);}});
		floor1_2.add(new Command() { @Override
			public Enemy get(int x, int y, Floor floor) { return EnemyGenerator.genEnemy("lich", x, y, floor);}});
		
		floor3_5 = new ArrayList<Command>(floor1_2);
		floor3_5.add(new Command() { @Override
			public Enemy get(int x, int y, Floor floor) { return EnemyGenerator.genEnemy("beastman", x, y, floor);}});
		floor3_5.add(new Command() { @Override
			public Enemy get(int x, int y, Floor floor) { return EnemyGenerator.genEnemy("skeleton", x, y, floor);}});
		
		elite = new ArrayList<Command>();
		elite.add(new Command() { @Override
			public Enemy get(int x, int y, Floor floor) { return EnemyGenerator.genEnemy("mindflayer", x, y, floor);}});
		elite.add(new Command() { @Override
			public Enemy get(int x, int y, Floor floor) { return EnemyGenerator.genEnemy("werewolf", x, y, floor);}});
		elite.add(new Command() { @Override
			public Enemy get(int x, int y, Floor floor) { return EnemyGenerator.genEnemy("deepone", x, y, floor);}});
		
		boss = new ArrayList<Command>();
		boss.add(new Command() { @Override
			public Enemy get(int x, int y, Floor floor) { return EnemyGenerator.genEnemy("hero", x, y, floor);}});
		boss.add(new Command() { @Override
			public Enemy get(int x, int y, Floor floor) { return EnemyGenerator.genEnemy("cerberus", x, y, floor);}});
		boss.add(new Command() { @Override
			public Enemy get(int x, int y, Floor floor) { return EnemyGenerator.genEnemy("minotaur", x, y, floor);}});
		
		pools.put("1", floor1_2);
		pools.put("2", floor1_2);
		pools.put("3", floor3_5);
		pools.put("4", floor3_5);
		pools.put("5", floor3_5);
		pools.put("elite", elite);
		pools.put("boss", boss);
	}
	
	public static Enemy pull(String pool, int x, int y, Floor floor) {
		return pull(pools.get(pool), x, y, floor);
	}
	
	private static Enemy pull(ArrayList<Command> pool, int x, int y, Floor floor) {
		int num = rng.nextInt(pool.size());
		return pool.get(num).get(x, y, floor);
	}

	
	private interface Command {
		public Enemy get(int x, int y, Floor floor);
	}
}
