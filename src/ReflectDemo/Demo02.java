package ReflectDemo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Demo02 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class<?> c = Class.forName("ReflectDemo.Student");

        // get construction func

        Constructor<?>[] cons = c.getConstructors(); // public construct
        for (Constructor con : cons) {
            System.out.println(con);
        }

        Constructor<?>[] deCons = c.getDeclaredConstructors(); // all cons
        for (Constructor con : deCons) {
            System.out.println(con);
        }
        String name = "123";

//        Student s = new Student("jason", 30, "shezhen");
        Constructor<?> con01 = c.getConstructor(String.class, int.class, String.class);
        Constructor<?> deCon01 = c.getDeclaredConstructor(String.class);

        Object obj01 = con01.newInstance("jason", 30, "shenzhen");
        System.out.println(obj01);

        // cancel access detect
        deCon01.setAccessible(true);
        Object obj02 = deCon01.newInstance("ivy");
        System.out.println(obj02);

        // class.getFields()
        // class.getDeclaredFields()

        Field[] fields = c.getFields();
        Field[] declaredFields = c.getDeclaredFields();

        Field address = c.getField("address");

        // get non args construction func to create obj
        Constructor<?> constructor = c.getConstructor();
        Object obj = constructor.newInstance();
        address.set(obj, "xi'an");
        System.out.println(obj);
    }

}
