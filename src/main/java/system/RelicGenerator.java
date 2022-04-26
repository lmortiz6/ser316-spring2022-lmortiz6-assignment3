package main.java.system;

import main.java.object.Relic;
import main.java.effect.*;
import main.java.effect.Effect.PROC_TYPE;

public class RelicGenerator {
	public static Relic genRelic(String name, int x, int y, Floor floor) {
		switch (name.toLowerCase()) {
		case "thorns":
			return genThorns(x, y, floor);
		case "vampire":
			return genVampire(x, y, floor);
		case "vessel":
			return genVessel(x, y, floor);
		case "bracer":
			return genBracer(x, y, floor);
		case "crown":
			return genCrown(x, y, floor);
		case "transfusion":
			return genTransfusion(x, y, floor);
		case "flesh":
			return genFlesh(x, y, floor);
		case "crystal":
			return genCrystal(x, y, floor);
		case "iron":
			return genIron(x, y, floor);
		case "shackles":
			return genShackles(x, y, floor);
		case "pupil":
			return genPupil(x, y, floor);
		case "bane":
			return genBane(x, y, floor);
		case "heart":
			return genHeart(x, y, floor);
		case "spirit":
			return genSpirit(x, y, floor);
		default:
			return genThorns(x, y, floor);
		}
	}
	
	private static Relic genThorns(int x, int y, Floor floor) {
		Relic newRelic = new Relic(x, y, floor);
		String name = "Thorned Spores";
		Thorns effect = new Thorns(null);
		String desc = "Covers your body in thorny growths. Deal damage to enemies that damage you.";
		
		newRelic.setUp(name, effect);
		newRelic.setDesc(desc);
		return newRelic;
	}
	
	private static Relic genVampire(int x, int y, Floor floor) {
		Relic newRelic = new Relic(x, y, floor);
		String name = "Vampire's Charm";
		Heal effect = new Heal(null, true);
		effect.setType(PROC_TYPE.TICK);
		effect.setMod(8);
		String desc = "Heal at end of turn after killing an enemy.";
		
		newRelic.setUp(name, effect);
		newRelic.setDesc(desc);
		return newRelic;
	}
	
	private static Relic genVessel(int x, int y, Floor floor) {
		Relic newRelic = new Relic(x, y, floor);
		String name = "Soul Vessel";
		EnGain effect = new EnGain(null);
		effect.setType(PROC_TYPE.KILL);
		effect.setMod(1);
		String desc = "Gain energy after killing enemies.";
		
		newRelic.setUp(name, effect);
		newRelic.setDesc(desc);
		return newRelic;
	}
	
	private static Relic genBracer(int x, int y, Floor floor) {
		Relic newRelic = new Relic(x, y, floor);
		String name = "Golden Bracer";
		AttackUp effect = new AttackUp(null, true, false);
		effect.setMod(50);
		String desc = "Deal more damage if your first action is an attack.";
		
		newRelic.setUp(name, effect);
		newRelic.setDesc(desc);
		return newRelic;
	}
	
	private static Relic genCrown(int x, int y, Floor floor) {
		Relic newRelic = new Relic(x, y, floor);
		String name = "Crown of Perfection";
		AttackUp effect = new AttackUp(null, false, true);
		effect.setMod(75);
		String desc = "Deal more damage at full HP";
		
		newRelic.setUp(name, effect);
		newRelic.setDesc(desc);
		return newRelic;
	}
	
	private static Relic genTransfusion(int x, int y, Floor floor) {
		Relic newRelic = new Relic(x, y, floor);
		String name = "Silver Transfusion Kit";
		Bandage effect = new Bandage(null);
		String desc = "Grants immunity to bleed.";
		
		newRelic.setUp(name, effect);
		newRelic.setDesc(desc);
		return newRelic;
	}
	
	private static Relic genFlesh(int x, int y, Floor floor) {
		Relic newRelic = new Relic(x, y, floor);
		String name = "Spongy Flesh";
		Antidote effect = new Antidote(null);
		effect.setType(PROC_TYPE.TICK);
		String desc = "Grants immunity to poison.";
		
		newRelic.setUp(name, effect);
		newRelic.setDesc(desc);
		return newRelic;
	}
	
	private static Relic genCrystal(int x, int y, Floor floor) {
		Relic newRelic = new Relic(x, y, floor);
		String name = "Fused Crystal";
		MagickDampen effect = new MagickDampen(null);
		String desc = "Skills cost less MP.";
		
		newRelic.setUp(name, effect);
		newRelic.setDesc(desc);
		return newRelic;
	}
	
	private static Relic genIron(int x, int y, Floor floor) {
		Relic newRelic = new Relic(x, y, floor);
		String name = "Iron Flesh";
		Defense effect = new Defense(null);
		String desc = "Increased defense.";
		
		newRelic.setUp(name, effect);
		newRelic.setDesc(desc);
		return newRelic;
	}
	
	private static Relic genShackles(int x, int y, Floor floor) {
		Relic newRelic = new Relic(x, y, floor);
		String name = "Wicked Shackles";
		MoveCost effect = new MoveCost(null);
		String desc = "Movement costs 1 more energy.";
		
		newRelic.setUp(name, effect);
		newRelic.setDesc(desc);
		return newRelic;
	}
	
	private static Relic genPupil(int x, int y, Floor floor) {
		Relic newRelic = new Relic(x, y, floor);
		String name = "Collapsed Pupil";
		AggroUp effect = new AggroUp(null);
		effect.setMod(3);
		String desc = "Enemies see you from further away.";
		
		newRelic.setUp(name, effect);
		newRelic.setDesc(desc);
		return newRelic;
	}
	
	private static Relic genBane(int x, int y, Floor floor) {
		Relic newRelic = new Relic(x, y, floor);
		String name = "Mage's Bane";
		MpGain effect = new MpGain(null);
		effect.setType(PROC_TYPE.TICK);
		effect.setMod(-1);
		String desc = "Lose 1 MP every turn.";
		
		newRelic.setUp(name, effect);
		newRelic.setDesc(desc);
		return newRelic;
	}
	
	private static Relic genHeart(int x, int y, Floor floor) {
		Relic newRelic = new Relic(x, y, floor);
		String name = "Weak Heart";
		BuildupDampen effect = new BuildupDampen(null);
		String desc = "Status ailment buildup decreases slower.";
		
		newRelic.setUp(name, effect);
		newRelic.setDesc(desc);
		return newRelic;
	}
	
	private static Relic genSpirit(int x, int y, Floor floor) {
		Relic newRelic = new Relic(x, y, floor);
		String name = "Mischievous Spirit";
		Teleport effect = new Teleport(null);
		effect.setType(PROC_TYPE.KILL);
		effect.setMod(-1);
		String desc = "Random chance to teleport after killing an enemy.";
		
		newRelic.setUp(name, effect);
		newRelic.setDesc(desc);
		return newRelic;
	}
}
