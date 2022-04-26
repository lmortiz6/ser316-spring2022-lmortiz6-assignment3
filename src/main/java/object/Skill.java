package main.java.object;

import java.awt.Point;
import java.util.ArrayList;

import main.java.effect.Effect;
import main.java.system.Floor;
import main.java.system.Hitbox;

public class Skill extends Item{
	
	int hpCost, mpCost, enCost;
	Hitbox hb;
	Effect effect;
	int modifier;
	int damage;

	public Skill(int x, int y, Floor floor) {
		super(x, y, floor);
		hpCost = 0;
		mpCost = 0;
		enCost = 0;
		modifier = 0;
		hb = null;
		effect = null;
		ascii = '§';
	}
	
	public void setUp(String name, int hp, int mp, int en, Hitbox hitbox, int mod, int dam) {
		this.name = name;
		hpCost = hp;
		mpCost = mp;
		enCost = en;
		hb = hitbox;
		modifier = mod;
		damage = dam;
	}
	
	public void setUp(String name, int hp, int mp, int en, Effect e, int mod) {
		this.name = name;
		hpCost = hp;
		mpCost = mp;
		enCost = en;
		effect = e;
		modifier = mod;
	}
	
	public int getHpCost() {
		return hpCost;
	}
	
	public int getMpCost() {
		return mpCost;
	}
	
	public int getEnCost() {
		return enCost;
	}
	
	public void use(String direction) {
		if (owner.getHP() < hpCost || owner.getMP() < mpCost || owner.getEnergy() < enCost) {
			return;
		}
		if (hb != null) {
			attack(direction);
		}
		else if (effect != null) {
			giveEffect();
		}
	}
	
	private void attack(String direction) {
		ArrayList<Point> positions = hb.getPositions(owner.getPosition(), direction);
		if (positions.isEmpty()) {
			return;
		}
		for (Point pt : positions) {
			if (floor.getEntity(pt.x, pt.y) != null) {
				Entity target = (Entity)floor.getEntity(pt.x, pt.y);
				if (owner.validTarget(target)) {
					if (modifier == 1) {
						target.buildPoison(50);
					}
					target.setAttacker(owner);
					target.damage(damage);
					target.setAttacker(null);
				}
			}
		}
		owner.heal(-hpCost);
		owner.mpGain(-mpCost);
		owner.enGain(-enCost);
	}
	
	private void giveEffect() {
		effect.setMod(modifier);
		effect.setOwner(owner);
		owner.addEffect(effect);
		if (effect.getType() == null) {
			effect.proc();
		}
		owner.removeEffects();
		owner.heal(-hpCost);
		owner.mpGain(-mpCost);
		owner.enGain(-enCost);
	}

}
