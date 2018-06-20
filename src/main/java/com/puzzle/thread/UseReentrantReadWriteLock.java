package com.puzzle.thread;

import java.util.concurrent.locks.ReentrantReadWriteLock;

import static java.lang.Thread.sleep;

/**
 * Created by Administrator on 2018/6/20 0020.
 */
public class UseReentrantReadWriteLock {

    static final UseReentrantReadWriteLock instance = new UseReentrantReadWriteLock();
    static int counter = 0;
    static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock(true);

    public static void read() {
        while (true) {
            rwl.readLock().lock();
            try {
                System.out.println("Counter is " + counter);
            } finally {
                rwl.readLock().unlock();
            }
            try {
                Thread.sleep(3000);
            } catch (Exception ie) {
            }
        }
    }

    public static void write() {
        while (true) {
            rwl.writeLock().lock();
            try {
                counter++;
                System.out.println("Incrementing counter.  Counter is " + counter);
            } finally {
                rwl.writeLock().unlock();
            }
            try {
                Thread.sleep(3000);
            } catch (Exception ie) {
            }
        }
    }

    public static void main(String[] args) {
        write();
        read();
    }
}


