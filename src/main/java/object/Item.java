package main.java.object;

import main.java.system.Floor;

public class Item extends GameObject{
	
	protected String name;
	protected Entity owner;
	protected String desc;

	public Item(int x, int y, Floor floor) {
		super(x, y, floor);
		desc = null;
	}
	
	public void pickUp(Entity entity) {
		main.java.ui.App.getFrame().log("Picked up " + name);
		this.owner = entity;
		entity.addItem(this);
		floor.removeItem(this);
	}
	
	public void setOwner(Entity entity) {
		this.owner = entity;
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getDesc() {
		return name + ": " + desc;
	}
	
	public String getName() {
		return name;
	}

}
