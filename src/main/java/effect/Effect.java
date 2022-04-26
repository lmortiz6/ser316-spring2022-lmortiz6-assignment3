package main.java.effect;

import main.java.object.Entity;

public class Effect {
	public enum PROC_TYPE {
		TURN,
		TICK,
		ATTACK,
		DAMAGED,
		KILL
	}
	
	protected PROC_TYPE type;
	protected int proc_ammo;
	protected Entity owner;
	protected boolean stackable;
	protected int modifier;
	
	public Effect(Entity owner) {
		this.owner = owner;
	}
	
	public PROC_TYPE getType() {
		return type;
	}
	
	public void setType(PROC_TYPE type) {
		this.type = type;
	}
	
	public void proc() {
		if (proc_ammo > 0) {
			proc_ammo--;
		}
	}
	
	public void exhaust() {
		if (proc_ammo == 0) {
			owner.removeEffect(this);
		}
	}
	
	public int getAmmo() {
		return proc_ammo;
	}
	
	public void setMod(int mod) {
		modifier = mod;
	}
	
	public void setOwner(Entity owner) {
		this.owner = owner;
	}
	
	public void setAmmo(int ammo) {
		proc_ammo = ammo;
	}
}
