package com.puzzle.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Administrator on 2018/7/5 0005.
 */
public class SemaphoreDemo {
    static AtomicInteger atomicInteger = new AtomicInteger(0);
    static CountDownLatch countDownLatch = new CountDownLatch(100);
    public static void main(String[] args) throws InterruptedException {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("market-pool-%d").build();
        Semaphore semaphore = new Semaphore(20);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(20, 200, 0, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<Runnable>(), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 100; i++) {
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        atomicInteger.getAndIncrement();
                        countDownLatch.countDown();
                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            });
        }
        countDownLatch.await();
        System.out.println(  atomicInteger.get());
        System.exit(1);

    }
}
