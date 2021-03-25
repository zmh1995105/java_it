package ReflectDemo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class Demo06 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
//        Student s = new Student();
//        s.study();

        Teacher t = new Teacher();
        t.teach();

        // load data
        Properties prop = new Properties();
        FileReader fr = new FileReader("class.txt");
        prop.load(fr);
        fr.close();

        System.out.println(prop);

        String className = prop.getProperty("className");
        String methodName = prop.getProperty("methodName");

        Class<?> aClass = Class.forName(className);
        Constructor<?> constructor = aClass.getConstructor();
        Object o = constructor.newInstance();
        Method method = aClass.getMethod(methodName);

        method.invoke(o);

    }
}
