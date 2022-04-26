package main.java.system;

import main.java.object.UseItem;
import main.java.effect.*;

public class UseItemGenerator {
	public static UseItem genUseItem(String name, int x, int y, int modifier) {
		switch (name.toLowerCase()) {
		case "hppotion":
			return genHpPotion(x, y, modifier);
		case "mppotion":
			return genMpPotion(x, y, modifier);
		case "enpotion":
			return genEnPotion(x, y, modifier);
		case "antidote":
			return genAntidote(x, y, modifier);
		case "teleport":
			return genTeleport(x, y, modifier);
		case "attackup":
			return genAttackUp(x, y, modifier);
		case "thorns":
			return genThorns(x, y, modifier);
		case "savingthrow":
			return genSavingThrow(x, y, modifier);
		default:
			return genHpPotion(x, y, modifier);
		}
	}
	
	private static UseItem genHpPotion(int x, int y, int modifier) {
		UseItem newItem = new UseItem(x, y, Game.currentFloor);
		Heal heal = new Heal(null, false);
		String name = "Potion of Vitality";
		if (modifier > 40) {
			name = "Great " + name;
		}
		String desc = "Restores " + modifier + " hp.";
		
		newItem.setUp(name, heal, modifier);
		newItem.setDesc(desc);
		return newItem;
	}
	
	private static UseItem genMpPotion(int x, int y, int modifier) {
		UseItem newItem = new UseItem(x, y, Game.currentFloor);
		MpGain mpgain = new MpGain(null);
		String name = "Potion of Magick";
		if (modifier > 40) {
			name = "Great " + name;
		}
		String desc = "Restores " + modifier + " mp.";
		
		newItem.setUp(name, mpgain, modifier);
		newItem.setDesc(desc);
		return newItem;
	}
	
	private static UseItem genEnPotion(int x, int y, int modifier) {
		UseItem newItem = new UseItem(x, y, Game.currentFloor);
		EnGain engain = new EnGain(null);
		String name = "Potion of Energy";
		if (modifier > 2) {
			name = "Great " + name;
		}
		String desc = "Restores " + modifier + " energy.";
		
		newItem.setUp(name, engain, modifier);
		newItem.setDesc(desc);
		return newItem;
	}
	
	private static UseItem genAntidote(int x, int y, int modifier) {
		UseItem newItem = new UseItem(x, y, Game.currentFloor);
		Antidote antidote = new Antidote(null);
		String name = "Antidote";
		String desc = "Cures poison.";
		
		newItem.setUp(name, antidote, modifier);
		newItem.setDesc(desc);
		return newItem;
	}
	
	private static UseItem genTeleport(int x, int y, int modifier) {
		UseItem newItem = new UseItem(x, y, Game.currentFloor);
		Teleport tp = new Teleport(null);
		String name = "Scroll of Teleportation";
		String desc = "Teleport to a random location.";
		
		newItem.setUp(name, tp, modifier);
		newItem.setDesc(desc);
		return newItem;
	}
	
	private static UseItem genAttackUp(int x, int y, int modifier) {
		UseItem newItem = new UseItem(x, y, Game.currentFloor);
		AttackUp attackup = new AttackUp(null, false, false);
		String name = "Scroll of ";
		if (modifier > 50) {
			name += "Great ";
		}
		name += "Strength";
		String desc = "Boosts damage of next attack";
		
		newItem.setUp(name, attackup, modifier);
		newItem.setDesc(desc);
		return newItem;
	}
	
	private static UseItem genThorns(int x, int y, int modifier) {
		UseItem newItem = new UseItem(x, y, Game.currentFloor);
		Thorns thorns = new Thorns(null);
		String name = "Scroll of Thorns";
		String desc = "Deal damage to next enemy that attacks you.";
		
		newItem.setUp(name, thorns, modifier);
		newItem.setDesc(desc);
		return newItem;
	}
	
	private static UseItem genSavingThrow(int x, int y, int modifier) {
		UseItem newItem = new UseItem(x, y, Game.currentFloor);
		SavingThrowBoost thrw = new SavingThrowBoost(null);
		String name = "Scroll of ";
		if (modifier > 5) {
			name += "Great ";
		}
		name += "Luck";
		String desc = "+" + modifier + " to next saving throw.";
		
		newItem.setUp(name, thrw, modifier);
		newItem.setDesc(desc);
		return newItem;
	}
}
