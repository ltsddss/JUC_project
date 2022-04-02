package com.lts.forkJoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

public class forkTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        test3();
    }

//    使用简单的for循环计算
    public static void test1(){
        Long sum=0L;
        long start=System.currentTimeMillis();

        for (Long i = 1L; i <=10_0000_0000L ; i++) {
            sum+=i;
        }

        long end=System.currentTimeMillis();
        System.out.println("sum="+sum+"时间为"+(end-start));
    }

//    使用forkjoin计算
    public static void test2() throws ExecutionException, InterruptedException {
        Long start=System.currentTimeMillis();

        ForkJoinPool forkJoinPool=new ForkJoinPool();

        ForkJoinTask<Long> forkjoin=new forkjoin(0L,10_0000_0000L);//创建ForkJoinTask任务
        ForkJoinTask<Long> task = forkJoinPool.submit(forkjoin);//提交创建的任务

        Long sum=task.get();//获取返回值
        Long end=System.currentTimeMillis();

        System.out.println("sum="+sum+"时间为"+(end-start));
    }
//    stream并行流
    public static void test3(){
        Long start=System.currentTimeMillis();

//        parallel并行计算
        Long sum=LongStream.rangeClosed(0L,10_0000_0000L).parallel().reduce(0,Long::sum);

        Long end=System.currentTimeMillis();

        System.out.println("sum="+sum+"时间为"+(end-start));
    }
}
