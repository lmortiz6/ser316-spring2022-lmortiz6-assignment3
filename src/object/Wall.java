package object;

import system.Floor;

public class Wall extends GameObject{

	public Wall (int x, int y, Floor floor) {
		super(x, y, floor);
		ascii = '□';
	}
}
