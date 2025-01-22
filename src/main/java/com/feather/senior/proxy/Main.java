package com.feather.senior.proxy;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Proxy;

/**
 * @author Milo
 * @date 2023/6/22 21:28
 */
@Slf4j
public class Main {
    public static void main(String[] args) {
        // 被代理对象
        UserServiceImpl userServiceImpl = new UserServiceImpl();

        // 代理对象
        Object proxyInstance = Proxy.newProxyInstance(Main.class.getClassLoader(),
                new Class[]{UserService.class},
                // 增强了 被代理对象的能力
                (proxy, method, args1) -> {
                    Object invoke;
//                    if ("addUser".equals(method.getName())) {
//                        log.debug("ready to add user");
//                        // 一定要使用被代理的对象 userServiceImpl， 如果使用 proxy， 则变成了递归
//                        invoke = method.invoke(userServiceImpl, args1);
//                    } else if ("sing".equals(method.getName())) {
//                        log.debug("开始唱歌");
//                        long begin = System.currentTimeMillis();
//                        invoke = method.invoke(userServiceImpl, args1);
//                        log.debug((String)invoke);
//                        long end = System.currentTimeMillis();
//                        log.debug("结束唱歌，一共唱了{}秒", (end-begin)/1000);
//                    } else {
                        log.debug("invoke begin");
                    invoke = method.invoke(userServiceImpl, args1);
                    log.debug("invoke end");
//                    }

                    return invoke;
                });

        UserService userServiceProxy = (UserService)proxyInstance;
        userServiceProxy.addUser("Alice");
        userServiceProxy.addAge("age");
        System.out.println(userServiceProxy.sing());
    }
}
