package com.jcfc.forkjoin;

import java.util.concurrent.RecursiveTask;

/**
 *  ForkJoin 框架
 *
 *      任务要继承extends RecursiveTask<Long>
 *
 *  Recursive：递归
 */
public class ForkJoinCalculate extends RecursiveTask<Long> {
    private static final long serialVersionUID = -8750538182264282474L;

    private long start;
    private long end;

    private static final long THRESHOLD = 10000;//阈值，拆到小于等于此值时就不会再拆分

    public ForkJoinCalculate(long start, long end) {
        this.start = start;
        this.end = end;
    }

    //每个子任务在调用fork方法时会调用compute方法
    @Override
    protected Long compute() {
        long sum = 0;
        long length = end - start;

        if (length <= THRESHOLD) {
            //达到阈值计算结果
            for (long i=start; i<=end; i++) {
                sum += i;
            }
            //return sum;//返回子任务计算结果
        } else {
            //未达到阈值继续递归拆分成两个子任务计算
            long middle = (start + end) / 2;
            ForkJoinCalculate left = new ForkJoinCalculate(start, middle);
            //fork方法：拆分子任务，同时压入线程队列
            left.fork();

            ForkJoinCalculate right = new ForkJoinCalculate(middle + 1, end);
            right.fork();

            //等待子任务执行完，并得到其结果
            Long leftResult = left.join();
            Long rightResult = right.join();

            //合并子任务
            sum = leftResult + rightResult;
        }
        return sum;
    }

}
