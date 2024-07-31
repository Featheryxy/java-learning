package com.feather.concurrent;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.RemovalListener;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author Milo
 * @date 7/19/2024 6:44 PM
 */
@Slf4j
public class GuavaCacheDemo {
    public static         Cache<String, String> cache = CacheBuilder.newBuilder()
            .maximumSize(1000)
            .expireAfterWrite(10, TimeUnit.MINUTES)
            .build();

    public static void main(String[] args) throws InterruptedException {


        Thread thread = new Thread(() -> {
            cache.put("Name", "milo");
            System.out.println(cache.getIfPresent("Name"));
            cache.put("Name", "milo1");
        });

        thread.start();

        Thread.sleep(3000);
        Thread thread1 = new Thread(() -> {
            System.out.println(cache.getIfPresent("Name"));
        });
        thread1.start();

    }
}
