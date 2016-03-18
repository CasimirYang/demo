import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Demo2Test{

    @Test
    public void Test() throws Exception {
        System.out.println("@Test(timeout = 50) Demo2Test");
    }


    @Test
    public void Test2() throws Exception {
        System.out.println("@Test(timeout = 50) Demo2Test__2");
    }

    @Before
    public void Before() throws Exception {
        System.out.println("Before Demo2Test");
    }

    @After
    public void After() throws Exception {
        System.out.println("@After Demo2Test");
    }
}