package com.puzzle.atomic;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Administrator on 2018/7/5 0005.
 */

/**
 * 原子更新Demo
 */
public class AtomicIntegerDemo {
    static CountDownLatch countDownLatch = new CountDownLatch(1000);
    static AtomicInteger atomicInteger = new AtomicInteger(0);
    static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("AtomicInteger-pool-%d").build();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(20, 200, 0, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<Runnable>(), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 1000; i++) {
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    atomicInteger.getAndIncrement();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    count ++;
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        System.out.println("线程安全的AtmicInteger" + atomicInteger.get());
        System.out.println("非线程安全的Integer" + count);
        System.exit(1);


    }

}
