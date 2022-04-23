package object;

import java.util.ArrayList;

import system.Effect;
import system.Floor;

public class Entity extends GameObject{
	
	protected int hp, hpMax; // hit points
	protected int mp, mpMax; // magic points
	protected int en, enMax; // energy
	protected int xp; // experience points
	protected int sp;  // skill points
	protected int vig; // vigor
	protected int mnd; // mind
	protected int end; // endurance
	protected int str; // strength
	protected int lck; // luck
	protected int arc; // arcane
	
	protected Weapon weapon;
	protected ArrayList<UseItem> useItems;
	protected ArrayList<Skill> skills;
	protected ArrayList<Relic> relics;
	protected ArrayList<Effect> effects;

	public Entity(int x, int y, Floor floor) {
		super(x, y, floor);
		sp = 0;
		xp = 0;
		weapon = null;
		useItems = new ArrayList<UseItem>();
		skills = new ArrayList<Skill>();
		relics = new ArrayList<Relic>();
	}
	
	public void setUp(int hpMax, int mpMax, int enMax, int vig, int mnd, int end, int str, int lck, int arc) {
		this.hpMax = hpMax;
		this.hp = hpMax;
		this.mpMax = mpMax;
		this.mp = mpMax;
		this.enMax = enMax;
		this.en = enMax;
		this.vig = vig;
		this.mnd = mnd;
		this.end = end;
		this.str = str;
		this.lck = lck;
		this.arc = arc;
	}
	
	public void move(String direction) {
		switch (direction.toUpperCase()) {
		case "NORTH":
			this.move(position.x, position.y - 1);
			break;
		case "EAST":
			this.move(position.x + 1, position.y);
			break;
		case "SOUTH":
			this.move(position.x, position.y + 1);
			break;
		case "WEST":
			this.move(position.x - 1, position.y);
			break;
		default:
			break;
		}
	}

	public void move(int x, int y) {
		if (!(floor.getObject(x, y) instanceof Wall) && !(floor.getObject(x, y) instanceof Entity)) {
			position.setLocation(x, y);
		}
	}
}
