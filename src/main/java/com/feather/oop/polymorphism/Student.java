package com.feather.oop.polymorphism;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Milo
 * @date 2023/6/23 20:54
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student  {
    private String name = "子类Student的名称";

    public void run() {
        System.out.println("学生可以跑");
    }

    public void study() {
        System.out.println("学生正在学习");
    }
}
