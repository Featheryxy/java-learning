package com.feather.gof.singleton;

public class SingletonHungry {
    // 饿汉式，在类加载的时候的创建实例, 双亲委派机制
    private static SingletonHungry singleton = new SingletonHungry();
    private SingletonHungry(){

    }

    public static SingletonHungry getInstance(){
        return singleton;
    }

}
