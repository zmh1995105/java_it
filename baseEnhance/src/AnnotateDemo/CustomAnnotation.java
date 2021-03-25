package AnnotateDemo;

public class CustomAnnotation {
    // 元注解 public @interface MyAnno
    // 属性： 接口中可以定义的抽象方法
    //      1. 属性返回值类型： 基本数据类型，String，枚举，注解，以上类型的数组

    // 反编译 javap myAnno.class

    @MyAnno
    public void show() {

    }
}
