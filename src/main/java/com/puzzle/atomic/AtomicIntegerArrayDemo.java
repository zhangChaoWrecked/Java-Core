package com.puzzle.atomic;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * Created by Administrator on 2018/7/5 0005.
 */

/**
 //AtomicIntegerArray对传入的value数组进行更改时不影响原value数组对应的值
 */
public class AtomicIntegerArrayDemo {
    static CountDownLatch countDownLatch = new CountDownLatch(1000);
    static int value[] = new int[]{0, 1, 2};
    static AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(value);

    public static void main(String[] args) throws InterruptedException {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("AtomicInteger-pool-%d").build();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(100, 200, 0, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<Runnable>(), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 1000; i++) {
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    atomicIntegerArray.addAndGet(0, 1);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        System.out.println("线程安全的AtmicIntegerArray" + atomicIntegerArray.get(0));
        System.out.println("非线程安全的IntegerArray" + value[0]);
        System.exit(1);


    }

}
