package JunitDemo;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    /**
     * init func
     * before test func, used to ask for source
     */
    @Before
    public void init() {
        System.out.println("init");
    }

    /**
     * to release source
     */
    @After
    public void close() {
        System.out.println("close");

    }

    public static void main(String[] args) {
        Calculator c = new Calculator();
        int res = c.add(1, 2);
        System.out.println(res);
    }

    @Test
    public void testAdd() {
        System.out.println("test add...");
        Calculator c = new Calculator();
        int res = c.add(1, 2);
//        System.out.println(res);
//        assert res == 3;
        Assert.assertEquals(3, res);
    }
}
