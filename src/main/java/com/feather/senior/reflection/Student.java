package com.feather.senior.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Date 2023/1/17 10:44
 * @Created by Milo
 */
public class Student {
    public String name;

    private int age;



    //（默认的构造方法）
    Student(String str){
        System.out.println("(默认)的构造方法 s = " + str);
    }
    //无参构造方法
    public Student(){
        System.out.println("调用了公有、无参构造方法执行了。。。");
    }
    //有一个参数的构造方法
    public Student(char name){
        System.out.println("姓名：" + name);
    }
    //有多个参数的构造方法
    public Student(String name ,int age){
        this.name = name;
        this.age = age;
        System.out.println("姓名："+name+"年龄："+ age);//这的执行效率有问题，以后解决。
    }
    //受保护的构造方法
    protected Student(boolean n){
        System.out.println("受保护的构造方法 n = " + n);
    }
    //私有构造方法
    private Student(int age){
        System.out.println("私有的构造方法   年龄："+ age);
    }

    private void eat(){
        System.out.println("吃饭");
    }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) throws Exception {
        Class<Student> clazz = Student.class;
        Constructor<Student> declaredConstructor = clazz.getDeclaredConstructor(String.class);
        Student student = declaredConstructor.newInstance("小明");
        System.out.println(student);


        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println(field);
        }

        System.out.println("-----");
        Field name = clazz.getDeclaredField("name");
        System.out.println(name.getName()+"---"+name.getType());
        name.set(student, "小红");

        Field age = clazz.getDeclaredField("age");
        age.set(student, 12);
        System.out.println(student);


        Method method = clazz.getDeclaredMethod("eat");
        Student student1 = new Student();
        method.invoke(student1);

        Student stu = new Student("小红", 13);
        Class<? extends Student> stuClass = stu.getClass();
        for (Field field : stuClass.getDeclaredFields()) {
            System.out.println(field.getName()+"--"+field.get(stu));
        }
    }

}
