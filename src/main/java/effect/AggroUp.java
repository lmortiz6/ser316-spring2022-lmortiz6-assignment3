package main.java.effect;

import main.java.object.Entity;

public class AggroUp extends Effect{

	public AggroUp(Entity owner) {
		super(owner);
		type = PROC_TYPE.TICK;
		modifier = 1;
	}
	
	@Override
	public void proc() {
		main.java.system.Ai.modifyAggro(modifier);
		owner.removeEffect(this);
	}

}
