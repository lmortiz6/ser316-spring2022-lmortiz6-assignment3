package main.java.object;

import java.awt.Point;
import java.util.ArrayList;

import main.java.system.Floor;
import main.java.system.Hitbox;

public class Weapon extends UseItem{
	
	private int damage;
	private int poison;
	private int bleed;
	private int energyCost;
	private Hitbox hb;

	public Weapon(int x, int y, Floor floor) {
		super(x, y, floor);
		ascii = '†';
	}
	
	public void setUp(String name, int damage, int poison, int bleed, int energyCost, Hitbox hb) {
		this.name = name;
		this.damage = damage;
		this.poison = poison;
		this.bleed = bleed;
		this.energyCost = energyCost;
		this.hb = hb;
	}
	
	@Override
	public void use() {
		owner.equipWeapon(this);
	}
	
	public int getDamage() {
		return damage;
	}
	public int getPoison() {
		return poison;
	}
	public int getBleed() {
		return bleed;
	}
	public int getEnergyCost() {
		return energyCost;
	}
	
	public ArrayList<Point> getPositions(Point origin, String direction) {
		return hb.getPositions(origin, direction);
	}
	
	public int getWidth() {
		return hb.getWidth();
	}
	public int getLength() {
		return hb.getLength();
	}

}
