package com.feather.senior.reflection;

/**
 * @Date 2023/1/17 10:42
 * @Created by Milo
 * 获取Class对象的方式有3种，一个类在堆内存中只存在一个对象
 */
public class OneClass {
    public static void main(String[] args) throws ClassNotFoundException {
        //第一种方式获取Class对象
        Student stu1 = new Student();//这一new 产生一个Student对象，一个Class对象。

        Class stuClass = stu1.getClass();//获取Class对象
        System.out.println(stuClass.getName()); // com.feather.senior.reflection.Student
        System.out.println(stuClass.getSimpleName()); // Student

        //第二种方式获取Class对象
        Class stuClass2 = Student.class;
        System.out.println(stuClass == stuClass2);//判断第一种方式获取的Class对象和第二种方式获取的是否是同一个

        //第三种方式获取Class对象
        Class stuClass3 = Class.forName("com.feather.senior.reflection.Student");
        System.out.println(stuClass3 == stuClass2);
    }
}
