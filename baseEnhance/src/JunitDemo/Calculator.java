package JunitDemo;

public class Calculator {

    /**
     * add
     * @param a
     * @param b
     * @return
     */
    public int add (int a, int b) {
        return a + b;
    }

    /**
     * sub
     * @param a
     * @param b
     * @return
     */
    public int sub (int a, int b) {
        return a - b;
    }

    @Check
    public void div() {
        System.out.println("1 / 0 = " + (1 / 0));
    }

    @Check
    public void mul() {
        System.out.println("1 * 2 = " + (1 * 2));
    }
}
