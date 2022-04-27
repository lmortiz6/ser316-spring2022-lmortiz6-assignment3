package main.java.object;

import main.java.effect.Effect;
import main.java.system.Floor;

public class Relic extends Item{
	
	protected Effect effect;

	public Relic(int x, int y, Floor floor) {
		super(x, y, floor);
		ascii = '⁕';
	}
	
	public void setUp(String name, Effect effect) {
		this.name = name;
		this.effect = effect;
	}
	
	@Override
	public void pickUp(Entity entity) {
		super.pickUp(entity);
		effect.setAmmo(-1);
		effect.setOwner(entity);
		entity.addEffect(effect);
	}

}
