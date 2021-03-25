package ReflectDemo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Demo04 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> c = Class.forName("ReflectDemo.Student");

//        Method[] methods = c.getMethods();
        Method[] methods = c.getDeclaredMethods();
        for(Method method : methods) {
            System.out.println(method);
        }

        Method function = c.getMethod("function");
        Method method1 = c.getMethod("method1");

        Constructor<?> constructor = c.getConstructor();
        Object obj = constructor.newInstance();
        method1.invoke(obj);

        Method method3 = c.getMethod("method3", String.class, int.class);
        Object res = method3.invoke(obj, "name", 30);
        System.out.println(res);

    }
}
