package com.lts.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class test1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        创建一个异步任务
        CompletableFuture<Integer> completableFuture=CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread().getName()+"ok");
            int i=10/0;
            return 123;
        });

//        当线程完成时输出
        System.out.println(completableFuture.whenComplete((t, u) -> {
            System.out.println("t=>" + t); //正常返回的数值
            System.out.println("u=>" + u);//异常的信息
        }).exceptionally((e) -> {//捕获异常时的错误信息
            System.out.println(e.getMessage());
            return 234;
        }).get());
    }
}
