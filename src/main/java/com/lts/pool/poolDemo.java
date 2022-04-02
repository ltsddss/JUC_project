package com.lts.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class poolDemo {

//    三大池化技术的使用方法
    //    使用池化技术来创建线程
    public static void main(String[] args) {
//        ExecutorService ThreadPool = Executors.newSingleThreadExecutor();// 这个线程池中只能有一个线程出现

//        ExecutorService ThreadPool=Executors.newFixedThreadPool(5);//创建一个固定线程池的大小为5

        ExecutorService ThreadPool=Executors.newCachedThreadPool();//创建一个可伸缩的线程池
        try{
            for (int i = 0; i <10 ; i++) {
                ThreadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"o k");
                });
            }
        }
        finally {
            ThreadPool.shutdown();
        }

    }


}
