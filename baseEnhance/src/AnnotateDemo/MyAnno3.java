package AnnotateDemo;

/*
    元注解： 用于描述注解的注解
        1. @Target: 描述注解能够作用的位置
        2. @Retention: 描述注解被保留的阶段
            1. @Retention(RetentionPolicy.RUNTIME)
               会保留到class的字节码文件中，并被jvm读取到
        3. @Documented: 描述注解是否被抽取到api文档中
            - javadoc Worker.java
        4. @Inherited: 描述注解是否被子类继承
*/

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface MyAnno3 {
}
