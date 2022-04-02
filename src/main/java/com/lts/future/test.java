package com.lts.future;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        创建一个异步任务

        CompletableFuture<Void> completedFuture= CompletableFuture.runAsync(()->{
//            模拟线程的计算
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName()+"线程计算完毕");
        });

//        主线程任务
        System.out.println("helloword");

//        获取线程
        completedFuture.get();
    }
}
