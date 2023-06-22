package com.feather.concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.Thread.sleep;


@Slf4j
public class FixedThreadPool {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(1);
        pool.submit(
                () -> {
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    log.info("task 1");
                }
        );

        pool.submit(
                () -> {
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    log.info("task 2");
                }
        );
        pool.shutdown();
        while (!pool.isTerminated()) {
            sleep(1000);
        }
        log.info("main thread goes on");
    }



}
