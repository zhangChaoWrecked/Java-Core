package com.puzzle.thread;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/7 0007.
 */
public class ProducerConsumerWithLinkedList {


    public static void main(String[] args) {
        List<Integer> stack = new LinkedList<Integer>();
        Producer producer = new Producer(stack);
        Consumer consumer = new Consumer(stack);
        producer.start();
        consumer.start();
    }
}
class Producer extends Thread {
    public Producer(List<Integer> s) {
        mStack = s;
    }
    List<Integer> mStack = null;
    int mNumber = 0;
    @Override
    public void run() {
        while (true) {
            synchronized (mStack) {
                while (!mStack.isEmpty()) {
                    try {
                        mStack.wait(); // this.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                mNumber++;
                System.out.println("Producer generates number:" + mNumber);
                mStack.add(mNumber);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mStack.notifyAll();// this.notifyAll();
            }
        }
    }
}
class Consumer extends Thread {
    public Consumer(List<Integer> s) {
        mStack = s;
    }
    List<Integer> mStack = null;
    @Override
    public void run() {
        while (true) {
            synchronized (mStack) {
                while (mStack.isEmpty()) {
                    try {
                        mStack.wait(); // this.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                int number = ((LinkedList<Integer>) mStack).removeLast();
                System.out.println("Consumer consumes number:" + number);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mStack.notifyAll();// this.notifyAll();
            }
        }
    }
}
