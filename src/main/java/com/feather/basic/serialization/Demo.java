package com.feather.basic.serialization;

import com.alibaba.fastjson.JSON;

import java.io.*;

/**
 * @author Milo
 * @date 6/2/2024 10:14 AM
 */
public class Demo {
    public static void main(String[] args) {
        User1 user1 = new User1();
        user1.setName("milo");
        user1.setAge(28);
        user1.setSuccess(true);

//        write(user1);
//        read();
        ;
        System.out.println(JSON.toJSONString(user1));
        // {"name":"milo","success":true}
        User1 newUser = JSON.parseObject(JSON.toJSONString(user1), User1.class);
        System.out.println(JSON.toJSONString(newUser));
        // User1{name='milo', age=0}
    }

    private static void read() {
        File tempFile = new File("tempFile");
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(tempFile));
            User1 user1 = (User1)ois.readObject();
            System.out.println(user1);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    private static void write(User1 user1) {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("tempFile"));
            oos.writeObject(user1);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            ;
        }
    }
}
