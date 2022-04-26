package main.java.object;

import main.java.effect.Effect;
import main.java.system.Floor;

public class UseItem extends Item{
	
	Effect effect;
	int modifier;

	public UseItem(int x, int y, Floor floor) {
		super(x, y, floor);
	}
	
	public void setUp(String name, Effect effect, int modifier) {
		this.name = name;
		this.effect = effect;
		this.modifier = modifier;
	}
	
	public void use() {
		effect.setMod(modifier);
		owner.addEffect(effect);
		if (effect.getType() == null) {
			effect.proc();
		}
		owner.removeEffects();
	}
	
	@Override
	public void pickUp(Entity entity) {
		super.pickUp(entity);
		if (effect != null) {
			effect.setOwner(entity);
		}
	}

}
