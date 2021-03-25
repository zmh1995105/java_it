package ReflectDemo;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReflectDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        // can create arbitrary obj and execute
        // arbitrary func without change codes
        Properties pro = new Properties();

        ClassLoader classLoader = ReflectDemo.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("pro.properties");
        pro.load(is);
        String className = pro.getProperty("className");
        String methodName = pro.getProperty("methodName");

        // load into cash
        Class<?> aClass1 = Class.forName(className);

        // create a obj instance
        Object o = aClass1.newInstance();

        // get method obj
        Method method = aClass1.getMethod(methodName);

        method.invoke(o);

    }
}
