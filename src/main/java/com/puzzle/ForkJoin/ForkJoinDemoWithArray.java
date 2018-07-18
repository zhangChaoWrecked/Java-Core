package com.puzzle.ForkJoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2018/7/18 0018.
 */

public class ForkJoinDemoWithArray extends RecursiveAction {

    // 2. 声明一个私有 int array 属性，名为 array，用来储存你要增加的 array 的元素。
    private int[] array;

    // 3. 声明2个私有 int 属性，名为 start 和 end，用来储存 此任务已经处理的元素块的头和尾的位置。
    private int start;
    private int end;

    // 4. 实现类的构造函数，初始化属性值。
    public ForkJoinDemoWithArray(int array[], int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    // 5. 用任务的中心逻辑来实现 compute()
    // 方法。如果此任务已经处理了超过100任务，那么把元素集分成2部分，再创建2个任务分别来执行这些部分，使用 fork() 方法开始执行，并使用
    // join() 方法等待它的终结。
    @Override
    protected void compute() {
        if (end - start > 100) {
            int mid = (start + end) / 2;
            ForkJoinDemoWithArray ForkJoinDemoWithArray1 = new ForkJoinDemoWithArray(array, start, mid);
            ForkJoinDemoWithArray ForkJoinDemoWithArray2 = new ForkJoinDemoWithArray(array, mid+1, end);

            ForkJoinDemoWithArray1.fork();
            ForkJoinDemoWithArray2.fork();

            ForkJoinDemoWithArray1.join();
            ForkJoinDemoWithArray2.join();

            // 6. 如果任务已经处理了100个元素或者更少，那么在每次操作之后让线程进入休眠5毫秒来增加元素。
        } else {
            for (int i = start; i < end; i++) {
                array[i]++;

//                try {
//                    Thread.sleep(5);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        }
    }

    public static void main(String[] args) throws Exception {

        // 8. 创建 ForkJoinPool 对象，名为 pool。
        ForkJoinPool pool = new ForkJoinPool();

        // 9. 创建 10，000个元素的整数 array ，名为 array。
        int array[] = new int[10000];

        // 10. 创建新的 ForkJoinDemoWithArray 对象来处理整个array。
        ForkJoinDemoWithArray ForkJoinDemoWithArray1 = new ForkJoinDemoWithArray(array, 0, array.length);

        // 11. 使用 execute() 方法 把任务发送到pool里执行。
        pool.execute(ForkJoinDemoWithArray1);

        // 12. 当任务还未结束执行，调用 showLog() 方法来把 ForkJoinPool 类的状态信息写入，然后让线程休眠一秒。
        while (!ForkJoinDemoWithArray1.isDone()) {
            showLog(pool);
            TimeUnit.SECONDS.sleep(1);
        }

        // 13. 使用 shutdown() 方法关闭pool。
        pool.shutdown();

        // 14. 使用 awaitTermination() 方法 等待pool的终结。
        pool.awaitTermination(1, TimeUnit.DAYS);

        // 15. 调用 showLog() 方法写关于 ForkJoinPool 类状态的信息并写一条信息到操控台表明结束程序。
        showLog(pool);
        System.out.printf("Main: End of the program.\n");
    }

    // 16. 实现 showLog() 方法。它接收 ForkJoinPool 对象作为参数和写关于线程和任务的执行的状态的信息。
    private static void showLog(ForkJoinPool pool) {
        System.out.printf("**********************\n");
        System.out.printf("Main: Fork/Join Pool log\n");
        System.out.printf("Main: Fork/Join 池的并行的级别: Parallelism:%d\n",
                pool.getParallelism());
        System.out.printf("Main: Fork/Join worker线程们的数量: Pool Size:%d\n",
                pool.getPoolSize());
        System.out.printf("Main: Fork/Join 此方法返回当前执行任务的线程的数量: Active Thread Count:%d\n",
                pool.getActiveThreadCount());
        System.out.printf("Main: Fork/Join 没有被任何同步机制阻塞的正在工作的线程: Running Thread Count:%d\n",
                pool.getRunningThreadCount());
        System.out.printf("Main: Fork/Join 已经提交给池还没有开始他们的执行的任务数: Queued Submission:%d\n",
                pool.getQueuedSubmissionCount());
        System.out.printf("Main: Fork/Join 已经提交给池已经开始他们的执行的任务数: QueuedTaskCount:%d\n",
                pool.getQueuedTaskCount());
        System.out.printf("Main: Fork/Join 这个池是否有queued任务还没有开始他们的执行: Queued Submissions:%s\n",
                pool.hasQueuedSubmissions());
        System.out.printf("Main: Fork/Join worker 线程已经从另一个线程偷取到的时间数: Steal Count:%d\n",
                pool.getStealCount());
        System.out.printf("Main: Fork/Join Pool: Terminated :%s\n",
                pool.isTerminated());
        System.out.printf("**********************\n");
    }
}