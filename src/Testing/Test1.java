package Testing;

import org.junit.*;
import static org.junit.Assert.*;

public class Test1 {

    @BeforeClass
    public void setUp() throws Exception {
    }
    
    @AfterClass
    public void tearDown() throws Exception {
    }

    @Test
    public void SampleTest() {
        assertEquals(1, 1);
    }
    
}

