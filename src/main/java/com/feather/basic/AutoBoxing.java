package com.feather.basic;

/**
 * @Date 2023/1/30 16:19
 * @Created by Milo
 */
public class AutoBoxing {
    public static void main(String[] args) {
        // 自动装箱
        Integer a = 3;
        // 等价于
        // Integer a = Integer.valueOf(3);


        // 自动拆箱
        int b = a;
        //  等价于
        //  int b = a.intValue();
    }
}
