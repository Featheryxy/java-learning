package com.feather.concurrent;

/**
 * @author Milo
 * @date 2023/8/24 23:28
 */
public class DeamonThread {
    public static void main(String[] args) {
        // t 线程模拟网络长连接
        Thread t = new Thread(() -> {
            // innerThread 线程模拟发送心跳的线程
            Thread  innerThread = new Thread(() -> {
                try {
                    while(true) {
                        System.out.println("发送心跳");
                        Thread.sleep(1_000);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, "inner");
            innerThread.setDaemon(true);
            innerThread.start();
            try {
                Thread.sleep(3_000);// 模拟长连接1秒以后就退出
                System.out.println("T Thread done");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        t.start();
    }

}
