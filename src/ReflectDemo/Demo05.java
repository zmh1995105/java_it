package ReflectDemo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Demo05 {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        // add String in a ArrayList<Integer>
        ArrayList<Integer> array = new ArrayList<>();
        array.add(20);
        array.add(10);
//        array.add("asd");

        Class<? extends ArrayList> aClass = array.getClass();

        Method add = aClass.getMethod("add", Object.class);
        add.invoke(array, "hello");

        System.out.println(array);


    }
}
