package com.feather.oop.polymorphism;

/**
 * @author Milo
 * @date 2023/6/23 20:52
 */
public class Teacher extends People {
    public String name = "子类Teacher的名称";

    @Override
    public void run() {
        System.out.println("老师可以跑");
    }


    public void teach() {
        System.out.println("老师正在教学");
    }
}
