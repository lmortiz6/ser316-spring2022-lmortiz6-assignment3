package system;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class RoomGenerator {

	long seed;
	Random rng;
	
	public RoomGenerator(long sd) {
		seed = sd;
		rng = new Random(seed);
	}

}
