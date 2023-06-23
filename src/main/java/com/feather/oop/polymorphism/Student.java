package com.feather.oop.polymorphism;

/**
 * @author Milo
 * @date 2023/6/23 20:54
 */
public class Student extends People {
    private String name = "子类Student的名称";

    @Override
    public void run() {
        System.out.println("学生可以跑");
    }

    public void study() {
        System.out.println("学生正在学习");
    }
}
