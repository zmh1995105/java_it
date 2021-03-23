package ReflectDemo;

public class Student {
    private String name;
    int age;
    public String address;

    public Student() {

    }

    private Student(String name) {
        this.name = name;
    }

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public void function() {
        System.out.println("func");
    }

    public void method1() {
        System.out.println("method1");
    }

    public void method2() {
        System.out.println("method2");
    }

    public String method3(String s, int i) {
        return s + ", " + i;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + "\'" +
                ", age=" + age +
                ", address='" + address + "\'" +
                "}";
    }
}

