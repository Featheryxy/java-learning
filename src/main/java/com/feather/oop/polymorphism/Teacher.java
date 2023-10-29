package com.feather.oop.polymorphism;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Milo
 * @date 2023/6/23 20:52
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {
    public String name = "子类Teacher的名称";

    public void run() {
        System.out.println("老师可以跑");
    }


    public void teach() {
        System.out.println("老师正在教学");
    }
}
