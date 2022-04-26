package main.java.effect;

import main.java.object.Entity;

public class MoveCost extends Effect{
	
	public MoveCost(Entity owner) {
		super(owner);
		type = PROC_TYPE.TURN;
		proc_ammo = 1;
		modifier = 1;
	}
	
	@Override
	public void proc() {
		super.proc();
		owner.modifyDefense(modifier);
		exhaust();
	}

}
