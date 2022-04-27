package testing;

import org.junit.*;

import main.java.object.Enemy;
import main.java.object.Player;
import main.java.object.Weapon;
import main.java.system.BasicAi;
import main.java.system.EnemyGenerator;
import main.java.system.Floor;
import main.java.system.FloorGenerator;
import main.java.system.Game;
import main.java.system.Hitbox;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.Date;
import java.util.Random;

public class FloorGenTest {

	static long seed;
	
    @BeforeClass
    public static void setUp() throws Exception {
    	Date date = new Date();
    	seed = date.getTime();
    }
    
    @AfterClass
    public static void tearDown() throws Exception {
    }

    @Test
    public void FloorTest() {
    	
    	Game.levelrng = new Random(seed);
    	Game.player = new Player(0, 0, null);
    	
    	Floor floor = FloorGenerator.generateFloor(0);
    	
        assertTrue(floor instanceof Floor);
    }
    
}

