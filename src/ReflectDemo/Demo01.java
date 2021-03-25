package ReflectDemo;

public class Demo01 {
    // get info of args or func when running and use then to create an obj
    // don't have to finish this when compiling and can extend when running
    public static void main(String[] args) throws ClassNotFoundException {
        // 1. use attribute of class
        // 2. use Object.getClass()
        // 3. forName(String objName)
        Class<Student> c1 = Student.class;
        System.out.println(c1);

        Class<Student> c2 = Student.class;
        System.out.println(c1 == c2);

        Student s = new Student();
        Class<? extends Student> c3 = s.getClass();
        System.out.println(c1 == c3);

        // can set in config files
        Class<?> c4 = Class.forName("ReflectDemo.Student");
        System.out.println(c1 == c4);


    }
}
