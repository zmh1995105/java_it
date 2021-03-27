package JunitDemo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestCheck {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, IOException {
        Calculator c = new Calculator();
        // 获取字节码文件对象
        Class<? extends Calculator> aClass = c.getClass();
        // 获取所有的方法
        Method[] methods = aClass.getMethods();

        int bugNum = 0;
        BufferedWriter bw = new BufferedWriter(new FileWriter("bug.txt"));
        // 判断方法上是否有check注解
        for (Method method : methods) {
            if (method.isAnnotationPresent(Check.class)) {
                // 有的话就执行
                try {
                    method.invoke(c);

                } catch (Exception e) {
                    // 捕获异常
                    //记录到文件中
                    bugNum++;
                    bw.write(method.getName() + " Error");
                    bw.newLine();
                    bw.write("Error name: " + e.getCause().getClass().getSimpleName());
                    bw.newLine();
                    bw.write("Error reason: " + e.getCause().getMessage());
                    bw.newLine();
                    bw.write("______");
                }
            }
        }

        bw.write("Total error num is " + bugNum);
        bw.flush();
        bw.close();
    }
}
