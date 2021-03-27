package AnnotateDemo;

public @interface MyAnno {
    /*
    1. 属性的返回值类型
        1. 基本数据类型
        2. String
        3. 枚举
        4. 注解
        5. 以上数据类型的数组
    2. 使用时需要给属性赋值
        1. 如果定义属性时，使用default可以不用赋值
        2. 如果只有一个属性需要赋值，而且是value，则可以省略属性名
     */
    int show1();
    String show2() default "jason";
    Person per();
    MyAnno2 anno2();
    String[] str2();

//    以下类型不允许
//    Demo01 w2();
//    void show();

    /*
    元注解： 用于描述注解的注解
        1. @Target: 描述注解能够作用的位置
        2. @Retention: 描述注解被保留的截断
        2. @Documented: 描述注解是否被抽取到api文档中
        4. @Inherited: 描述注解是否被子类继承
     */



}
