package com.feather.senior.reflection;

import java.lang.reflect.Field;

/**
 * @author Milo
 * @date 2025/2/6 13:38
 */
public class FieldAccessible {
    public static class MyClass {
        private final String theField = "1";
    }

    public static void main(String[] args) throws Exception {
        MyClass myClass = new MyClass();
        Field field1 = myClass.getClass().getDeclaredField("theField");
        field1.setAccessible(true);
        System.out.println(field1.get(myClass)); // no exception
        Field field2 = myClass.getClass().getDeclaredField("theField");
        System.out.println(field2.get(myClass)); // IllegalAccessException
    }
}
