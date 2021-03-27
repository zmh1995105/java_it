package AnnotateDemo;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

@ProAnno(className = "AnnotateDemo.Demo02", methodName = "show")
public class ReflectDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        // can create arbitrary obj and execute
        // arbitrary func without change codes
        // use annotation to replace configs

        // 1. 解析注解

        // 获取该类的字节码文件对象
        Class<ReflectDemo> reflectDemoClass = ReflectDemo.class;
        // 获取上边的注解对象，在内存中生成了一个该注解接口的一个子类对象
        // implement了一个proAnno，并实现了接口方法
        ProAnno annotation = reflectDemoClass.getAnnotation(ProAnno.class);
        // 调用注解对象中定义的抽象方法，并获得返回值
        String s = annotation.className();
        String s1 = annotation.methodName();
        System.out.println(s + ", " + s1);

        Class<?> aClass = Class.forName(s);
        Object o = aClass.newInstance();
        Method method = aClass.getMethod(s1);
        method.invoke(o);
    }
}
