package main.java.object;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;

import main.java.effect.*;
import main.java.effect.Effect.PROC_TYPE;
import main.java.system.Floor;

public class Entity extends GameObject{
	
	public final int POISON_PROC = 50;
	public final int BLEED_PROC = 50;
	public final int FIRST_LEVEL = 100;
	
	public final int WALK_COST = 2;
	
	protected String name;
	protected boolean tookTurn;
	
	protected int hp, hpMax, hpBase;  // hit points
	protected int mp, mpMax, mpBase;  // magic points
	protected int en, enMax, enBase;  // energy
	protected int xp, givexp, levelxp;// experience points
	protected int sp;  // skill points
	
	protected int vig; // vigor
	protected int mnd; // mind
	protected int end; // endurance
	protected int str; // strength
	protected int lck; // luck
	
	protected Weapon weapon;
	protected ArrayList<UseItem> useItems;
	protected ArrayList<Skill> skills;
	protected ArrayList<Relic> relics;
	
	protected ArrayList<Effect> effects;
	protected ArrayList<Effect> fxToRemove;
	protected int poisonBuildup;
	protected int bleedBuildup;
	protected double damageBonus, damageBonusStart;
	protected int savingThrowBonus;
	protected int hpBonus;
	protected int mpBonus;
	protected int enBonus;
	protected double defenseBonus;
	protected double magickBonus;
	protected int moveBonus;
	protected double buildupBonus;
	
	protected Item dropItem;
	protected Entity attacker;
	protected boolean enemyKilled;

	public Entity(int x, int y, Floor floor) {
		super(x, y, floor);
		sp = 0;
		xp = 0;
		levelxp = FIRST_LEVEL;
		weapon = null;
		useItems = new ArrayList<UseItem>();
		skills = new ArrayList<Skill>();
		relics = new ArrayList<Relic>();
		
		effects = new ArrayList<Effect>();
		fxToRemove = new ArrayList<Effect>();
		effects.add(new VigorBoost(this));
		effects.add(new MindBoost(this));
		effects.add(new EnduranceBoost(this));
		effects.add(new StrengthBoost(this));
		effects.add(new LuckBoost(this));
		
		poisonBuildup = 0;
		bleedBuildup = 0;
		tookTurn = false;
		damageBonus = 1;
		damageBonusStart = 1;
		savingThrowBonus = 0;
		hpBonus = 0;
		mpBonus = 0;
		enBonus = 0;
		defenseBonus = 1;
		magickBonus = 1;
		moveBonus = 0;
		buildupBonus = 1;
		dropItem = null;
		attacker = null;
		enemyKilled = false;
	}
	
	////// GENERATE //////
	
	public void setUp(String name, char ascii, int hpMax, int mpMax, int enMax, int givexp,
						int vig, int mnd, int end, int str, int lck, Item dropItem) {
		this.name = name;
		this.ascii = ascii;
		this.hpBase = hpMax;
		this.hpMax = hpMax;
		this.hp = hpMax;
		this.mpBase = mpMax;
		this.mpMax = mpMax;
		this.mp = mpMax;
		this.enBase = enMax;
		this.enMax = enMax;
		this.en = enMax;
		this.givexp = givexp;
		this.vig = vig;
		this.mnd = mnd;
		this.end = end;
		this.str = str;
		this.lck = lck;
		this.dropItem = dropItem;
	}
	
	////// TURNS //////
	
	public void takeTurn() {
		tookTurn = false;
		hpBonus = 0;
		mpBonus = 0;
		enBonus = 0;
		damageBonusStart = 1;
		savingThrowBonus = 0;
		defenseBonus = 1;
		magickBonus = 1;
		moveBonus = 0;
		buildupBonus = 1;
		for (Iterator<Effect> it = effects.iterator(); it.hasNext(); ) {
			Effect effect = it.next();
			if (effect.getType() == PROC_TYPE.TURN) {
				effect.proc();
			}
		}
		removeEffects();
		hpMax = hpBase+hpBonus;
		mpMax = mpBase+mpBonus;
		enMax = enBase+enBonus;
		energize();
		damageBonusStart = damageBonus;
		enemyKilled = false;
	}
	
	public void endTurn() {
		for (Iterator<Effect> it = effects.iterator(); it.hasNext(); ) {
			Effect effect = it.next();
			if (effect.getType() == PROC_TYPE.TICK) {
				effect.proc();
			}
		}
		removeEffects();
		if (poisonBuildup > 0) {
			poisonBuildup -= Math.min(10 / buildupBonus, poisonBuildup);
		}
		if (bleedBuildup > 0) {
			bleedBuildup -= Math.min(7 / buildupBonus, bleedBuildup);
		}
		en = 0;
		tookTurn = true;
	}
	
	////// GET STATS //////
	
	public int getMaxHP() {
		return hpMax;
	}
	public int getHP() {
		return hp;
	}
	
	public int getMP() {
		return mp;
	}
	
	public int getMaxEnergy() {
		return enMax;
	}
	public int getEnergy() {
		return en;
	}
	
	public int getVigor() {
		return vig;
	}
	public int getMind() {
		return mnd;
	}
	public int getEndurance() {
		return end;
	}
	public int getStrength() {
		return str;
	}
	public int getLuck() {
		return lck;
	}
	
	public int getDamage() {
		damageBonus = damageBonusStart;
		for (Iterator<Effect> it = effects.iterator(); it.hasNext(); ) {
			Effect effect = it.next();
			if (effect.getType() == PROC_TYPE.ATTACK) {
				effect.proc();
			}
		}
		removeEffects();
		return (int)(weapon.getDamage() * damageBonus);
	}
	
	public boolean killedEnemy() {
		return enemyKilled;
	}
	
	////// INVENTORY //////
	
	public void equipWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	public void addItem(Item item) {
		if (item instanceof UseItem) {
			useItems.add((UseItem)item);
		}
		else if (item instanceof Skill) {
			skills.add((Skill)item);
		}
		else if (item instanceof Relic) {
			relics.add((Relic)item);
		}
 	}
	public void removeItem(Item item) {
		if (item instanceof UseItem) {
			useItems.remove((UseItem)item);
		}
		else if (item instanceof Skill) {
			skills.remove((Skill)item);
		}
		else if (item instanceof Relic) {
			relics.remove((Relic)item);
		}
	}
	
	////// EFFECTS //////
	
	public ArrayList<Effect> getEffects() {
		return effects;
	}
	
	public void addEffect(Effect effect) {
		effects.add(effect);
	}
	public void removeEffect(Effect effect)	{
		fxToRemove.add(effect);
	}
	public void removeEffects() {
		for (Effect effect : fxToRemove) {
			effects.remove(effect);
		}
		fxToRemove.clear();
	}
	
	public void modifyDamage(double amount) {
		damageBonus *= amount;
	}
	public void modifySavingThrow(int amount) {
		savingThrowBonus += amount;
		if (savingThrowBonus > 14) {
			savingThrowBonus = 14;
		}
	}
	public void modifyHp(int amount) {
		hpBonus += amount;
	}
	public void modifyMp(int amount) {
		mpBonus += amount;
	}
	public void modifyEn(int amount) {
		enBonus += amount;
	}
	public void modifyDefense(double amount) {
		defenseBonus *= amount;
	}
	public void modifyMagick(double amount) {
		magickBonus *= amount;
	}
	public void modifyMoveCost(int amount) {
		moveBonus += amount;
	}
	public void modifyBuildup(double amount) {
		buildupBonus *= amount;
	}
	
	////// ACTIONS //////
	
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
		if (en < WALK_COST + moveBonus) {
			return;
		}
		GameObject obj = floor.getObject(x, y);
		if (obj instanceof Wall || obj instanceof Entity) {
			return;
		}
		else {
			position.setLocation(x, y);
			en -= WALK_COST + moveBonus;
		}
	}
	
	public void attack(String direction) {
		if (weapon == null) {
			return;
		}
		if (en < weapon.getEnergyCost()) {
			return;
		}
		System.out.println(name + " attacks!");
		ArrayList<Point> positions = weapon.getPositions(position, direction);
		if (positions.isEmpty()) {
			return;
		}
		for (Point pt : positions) {
			if (floor.getEntity(pt.x, pt.y) != null) {
				Entity target = (Entity)floor.getEntity(pt.x, pt.y);
				if (validTarget(target) && !target.savingThrow(-7)) {
					target.buildPoison(weapon.getPoison());
					target.buildBleed(weapon.getBleed());
					target.setAttacker(this);
					target.damage(getDamage());
					target.setAttacker(null);
				}
			}
		}
		en -= weapon.getEnergyCost();
	}
	public boolean validTarget(Entity target) {
		return true;
	}
	
	public boolean savingThrow(int bonus) {
		if (main.java.system.Game.dice.nextInt(20) + bonus + savingThrowBonus > main.java.system.Game.dice.nextInt(20)) {
			System.out.println("Dodged!");
			return true;
		}
		return false;
	}
	
	////// RECIEVED //////
	
	public void damage(int amount) {
		hp -= amount;
		for (Iterator<Effect> it = effects.iterator(); it.hasNext(); ) {
			Effect effect = it.next();
			if (effect.getType() == PROC_TYPE.DAMAGED) {
				effect.proc();
			}
		}
		removeEffects();
		if (hp <= 0) {
			hp = 0;
			destroy();
		}
	}
	public void damageNoEffects(int amount) {
		hp -= amount;
		if (hp <= 0) {
			hp = 0;
			destroy();
		}
	}
	public void destroy() {
		System.out.println(name + " destroyed!");
		floor.removeEntity(this);
		if (attacker != null) {
			attacker.killedBy();
		}
	}
	public void setAttacker(Entity attacker) {
		this.attacker = attacker;
	}
	public Entity getAttacker() {
		return attacker;
	}
	
	public void heal(int amount) {
		hp += amount / defenseBonus;
		if (hp > hpMax) {
			hp = hpMax;
		}
	}
	
	public void mpGain(int amount) {
		mp += amount / magickBonus;
		if (mp > mpMax) {
			mp = mpMax;
		}
	}
	
	public void enGain(int amount) {
		en += amount;
	}
	
	public void buildPoison(int amount) {
		for (Iterator<Effect> it = effects.iterator(); it.hasNext(); ) {
			Effect effect = it.next();
			if (effect instanceof Poison) {
				return;
			}
		}
		removeEffects();
		poisonBuildup += amount;
		if (poisonBuildup >= POISON_PROC) {
			poisonBuildup = 0;
			poison();
		}
	}
	public void poison() {
		effects.add(new Poison(this));
	}
	
	public void buildBleed(int amount) {
		bleedBuildup += amount;
		if (bleedBuildup >= BLEED_PROC) {
			bleedBuildup = 0;
			bleed();
		}
	}
	public void bleed() {
		effects.add(new Bleed(this));
	}
	
	public void giveXP(int amount) {
		xp += amount;
		if (xp >= levelxp) {
			xp -= levelxp;
			sp++;
			levelxp *= 1.5;
		}
	}
	
	public void killedBy() {
		enemyKilled = true;
		for (Iterator<Effect> it = effects.iterator(); it.hasNext(); ) {
			Effect effect = it.next();
			if (effect.getType() == PROC_TYPE.KILL) {
				effect.proc();
			}
		}
		removeEffects();
	}
	
	public void energize() {
		en = enMax;
	}
	
	public String toString() {
		String str = "";
		str += "Name: " + name + "\n";
		str += "HP: " + hp + "\n";
		/*str += "MP: " + mp + "\n";
		str += "EN: " + en + "\n";
		str += "XP: " + xp + "\n";*/
		return str;
	}
}
