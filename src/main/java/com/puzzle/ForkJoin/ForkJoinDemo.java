package com.puzzle.ForkJoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * Created by Administrator on 2018/7/18 0018.
 */
public class ForkJoinDemo extends RecursiveTask<Integer> {


    private static final int THREAD_HOLD = 10000;

    private int start;
    private int end;

    public ForkJoinDemo(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        //如果任务足够小就计算
        boolean canCompute = (end - start) <= THREAD_HOLD;
        if (canCompute) {
            for (int i = start; i <= end; i++) {
                sum += i;
                for (int j = start; j <= end; j++) {

                }
            }
            System.out.printf("一个任务\n");

        } else {
            int middle = (start + end) / 2;
            ForkJoinDemo left = new ForkJoinDemo(start, middle);
            ForkJoinDemo right = new ForkJoinDemo(middle + 1, end);
            //执行子任务
            left.fork();
            right.fork();
            //获取子任务结果
            int lResult = left.join();
            int rResult = right.join();
            sum = lResult + rResult;
        }
        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinDemo task = new ForkJoinDemo(1, 10000);
        long start = System.currentTimeMillis();

        Future<Integer> result = pool.submit(task);
        try {
            System.out.println(result.get());
            long end = System.currentTimeMillis();
            System.out.println("结束时间" + (end - start));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

