package testing;

import org.junit.*;

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
    	
    	fgen.generateFloor();
    	
        assertEquals(1, 1);
    }
    
}

