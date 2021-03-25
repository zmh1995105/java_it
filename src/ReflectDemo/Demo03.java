package ReflectDemo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Demo03 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class<?> c = Class.forName("ReflectDemo.Student");

        Constructor<?> con = c.getConstructor();
        Object obj = con.newInstance();

        System.out.println(obj);

        Field name = c.getDeclaredField("name");
        name.setAccessible(true);
        name.set(obj, "jason");
        System.out.println(obj);

        Field age = c.getDeclaredField("age");
        age.setAccessible(true);
        age.set(obj, 30);

        Field address = c.getField("address"); // only public field
        address.set(obj, "shenzhen");
        System.out.println(obj);

    }
}
