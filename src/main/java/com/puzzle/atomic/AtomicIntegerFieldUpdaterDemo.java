package com.puzzle.atomic;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by Administrator on 2018/7/5 0005.
 */

/**
 * //AtomicIntegerFieldUpdater 原子更新引用类型的字段  字段必须设置为 public  volatile
 */
public class AtomicIntegerFieldUpdaterDemo {
    static CountDownLatch countDownLatch = new CountDownLatch(100);
    static User user = new User("Wrecked", 0);
    static User user2 = new User("Wrecked", 0);

    public static AtomicIntegerFieldUpdater<User> atomicIntegerFieldUpdater = AtomicIntegerFieldUpdater.newUpdater(User.class, "age");

    public static void main(String[] args) throws InterruptedException {


        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("AtomicInteger-pool-%d").build();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(100, 200, 0, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<Runnable>(), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 100; i++) {
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    // atomicIntegerFieldUpdater.getAndIncrement(user); age 每次+1
                    //atomicIntegerFieldUpdater.addAndGet(user, 2); //age 每次利用旧值加2
                    atomicIntegerFieldUpdater.getAndAdd(user,2);//age 每次利用旧值加2
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    user2.setAge(user2.getAge() + 1);
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        System.out.println("线程安全的AtomicReference<User>" + atomicIntegerFieldUpdater.get(user));
        System.out.println("非线程安全的User" + user2.getAge());
        System.exit(1);
    }

    static class User {
        private String name;
        public volatile int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public User(String name, Integer age) {
            this.name = name;
            this.age = age;
        }
    }


}
