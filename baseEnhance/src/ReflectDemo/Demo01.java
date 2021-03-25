package ReflectDemo;

public class Demo01 {
    public static void main(String[] args) throws ClassNotFoundException {
        // three way to get class obj
        // 1. class.forName("className") 加载字节码文件进入内存
        Class<?> cls1 = Class.forName("ReflectDemo.Person");
        System.out.println(cls1);

        // 2. className.class  在内存中获得类对象，多用于传参的形式
        Class<?> cls2 = Person.class;

        // 3. object.getClass() 运行时获得类对象，多用于对象的获取字节码的方式
        Person p = new Person();
        Class<?> cls3 = p.getClass();

        System.out.println(cls1 == cls2);
        System.out.println(cls1 == cls3);
        System.out.println(cls2 == cls3);


    }
}
