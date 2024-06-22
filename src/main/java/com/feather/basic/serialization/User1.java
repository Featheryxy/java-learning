package com.feather.basic.serialization;

import java.io.Serializable;

/**
 * @author Milo
 * @date 6/2/2024 10:13 AM
 */
public class User1 implements Serializable {
//     保证读写时的版本一样
    private static final long serialVersionUID = 6529685098267757690L;

    private String name;
    // transient 持久化时被忽略，反序列化时被设置为初始值
    private transient int age;

    private boolean success;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }



    private Object readResolve(){
        Object singleton = new Object();
        return singleton;
    }
}
