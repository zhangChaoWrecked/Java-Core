package com.puzzle.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2018/6/20 0020.
 */
public class UseReentrantLock {
    public static void main(String[] args) {
        int[] runningThreads = {0};
        int[] taskcount = {10};
        Lock myLock = new ReentrantLock(true);
        int maxThreadQty = 3;
        while ((taskcount[0] > 0) && (runningThreads[0] < maxThreadQty)) {
            myLock.lock();
            runningThreads[0]++;
            System.out.println(Thread.currentThread().getName()+"当前任务数"+taskcount[0]+"当前线程数"+runningThreads[0]);
            myLock.unlock();
            new Thread() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"上锁前任务数"+taskcount[0]+"上锁前线程数"+runningThreads[0]);
                    myLock.lock();
                    taskcount[0]--;
                    runningThreads[0]--;
                    myLock.unlock();
                    System.out.println(Thread.currentThread().getName()+"解锁后任务数"+taskcount[0]+"解锁后线程数"+runningThreads[0]);
                }
            }.start();
        }
    }


}
