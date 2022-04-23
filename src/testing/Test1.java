package testing;

import org.junit.*;

import object.Player;
import system.Floor;
import system.FloorGenerator;

import static org.junit.Assert.*;

import java.util.Date;

public class Test1 {

	static FloorGenerator fgen;
	
    @BeforeClass
    public static void setUp() throws Exception {
    	Date date = new Date();
    	fgen = new FloorGenerator(date.getTime());
    }
    
    @AfterClass
    public static void tearDown() throws Exception {
    }

    @Test
    public void SampleTest() {
    	
    	Floor floor = fgen.generateFloor(0);
    	Player player = new Player(floor.getLayout().getRoomList().get(0).getPositionAbs().x + 5, floor.getLayout().getRoomList().get(0).getPositionAbs().y + 4, floor);
    	floor.addEntity(player);
    	floor.printFloorplan();
    	
    	for (int i = 0; i < 20; i++) {
    		player.move("NORTH");
    		floor.printFloorplan();
    	}
    	
        assertEquals(1, 1);
    }
    
}

