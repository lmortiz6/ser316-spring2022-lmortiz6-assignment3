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

public class Test1 {

	static FloorGenerator fgen;
	static long seed;
	
    @BeforeClass
    public static void setUp() throws Exception {
    	Date date = new Date();
    	seed = date.getTime();
    	fgen = new FloorGenerator(seed);
    }
    
    @AfterClass
    public static void tearDown() throws Exception {
    }

    @Test
    public void SampleTest() {
    	
    	Floor floor = fgen.generateFloor(0);
    	Player player = new Player(floor.getLayout().getRoomList().get(0).getPositionAbs().x + 5, floor.getLayout().getRoomList().get(0).getPositionAbs().y + 4, floor);
    	floor.addEntity(player);
    	
    	Weapon weapon1 = new Weapon(0, 0, floor);
    	weapon1.setUp("Hammer", 300, 0, 0, 2, new Hitbox(1, 1));
    	
    	player.setUp("Tom", player.getAscii(), 100, 100, 4, 10, 10, 10, 10, 10, 10, null);
    	player.equipWeapon(weapon1);
    	Game.player = player;
    	Game.setUp(seed);
    	Game.currentFloor = floor;
    	
    	Enemy enemy = EnemyGenerator.genEnemy("imp", player.getPosition().x + 4, player.getPosition().y - 1);
    	floor.addEntity(enemy);
    	
    	floor.printFloorplan();
    	
    	for (int i = 0; i < 5; i++) {
    		player.takeTurn();
    		player.endTurn();
    		enemy.takeTurn();
    		floor.printFloorplan();
    		System.out.println(player.toString());
    	}
    	
    	player.takeTurn();
    	player.attack("EAST");
		floor.printFloorplan();
		System.out.println(player.toString());
    	
    	
        assertEquals(1, 1);
    }
    
}

