package com.puzzle.collection.queue;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by Administrator on 2018/4/23 0023.
 */

class Producer implements Runnable {
    private String name;

    private BlockingDeque<Integer> deque;

    public Producer(String name, BlockingDeque<Integer> deque) {
        this.name = name;
        this.deque = deque;
    }

    public synchronized void run() {

        for (int i = 0; i < 10; i++) {
            try {
                deque.putFirst(i);
                System.out.println(name + " puts " + i);
                Thread.sleep(300);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

class Consumer implements Runnable {
    private String name;

    private BlockingDeque<Integer> deque;

    public Consumer(String name, BlockingDeque<Integer> deque) {
        this.name = name;
        this.deque = deque;
    }

    public synchronized void run() {
        for (int i = 0; i < 10; i++) {
            try {
                int j = deque.takeLast();
                System.out.println(name + " takes " + j);
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ProducerConsumerBlockingQueue {
    public static void main(String[] args) {
        BlockingDeque<Integer> deque = new LinkedBlockingDeque<Integer>(5);
        Runnable producer = new Producer("Producer", deque);
        Runnable consumer = new Consumer("Consumer", deque);
        new Thread(producer).start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(consumer).start();
    }
}

