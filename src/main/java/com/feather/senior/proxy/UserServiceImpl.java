package com.feather.senior.proxy;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Milo
 * @date 2023/6/22 21:29
 */
@Slf4j
public class UserServiceImpl implements UserService{
    @Override
    public boolean addUser(String name) {
        log.debug("Adding user: {}", name);
        return true;
    }

    @Override
    public boolean addAge(String age) {
        log.debug("Adding addAge: {}", age);
        return false;
    }

    @Override
    public String sing() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "user is singing love story ";
    }
}
