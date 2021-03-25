package AnnotateDemo;

/**
 * @author jason0211
 * @version 1.0
 * @since 1.5
 */
//@SuppressWarnings("all")
public class Demo01 {
    /**
     * use javadoc Demo01.java
     * @param a integer
     * @param b integer
     * @return add res
     */
    public int add(int a, int b) {
        return a + b;
    }

    // 1. @Override: check if inherit from father class
    // 2. @Deprecate: mark one annotation outdated
    // 3. SuppressWarnings


    @Override
    public String toString() {
        return super.toString();
    }

    @Deprecated
    public void show1() {
        System.out.println("outdated");
    }


    public void show2() {
        System.out.println("now");
    }

    @Deprecated
    public void show3() {
        System.out.println("suppresswarnings");
    }

    public void demo() {
        show1();
        show3();
    }
}
