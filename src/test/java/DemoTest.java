import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DemoTest {

    @org.junit.Before
    public void setUp() throws Exception {
             System.out.println("Before3 DemoTest");
    }
    @Before
    public void setUp2() throws Exception {
        System.out.println("Before2 DemoTest");
    }

    @org.junit.After
    public void tearDown() throws Exception {
        System.out.println("After3 DemoTest");
    }
    @org.junit.After
    public void tearDown2() throws Exception {
        System.out.println("After2 DemoTest");
    }
    @Test
    public void evaluatesExpression() {
        System.out.println("evaluatesExpression");
        assertEquals(16, 16);
       // System.out.println("@evaluatesExpression:"+5/0);
    }

    @Test
    @Ignore
    public void test() {
         assertEquals(16, 62);
        System.out.println("@test");
    }

    @BeforeClass
    public static void BeforeClass(){
//        assertEquals(16, 62);
        System.out.println("@BeforeClass");
    }
}