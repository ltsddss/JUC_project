package com.lts.pool;

import java.util.concurrent.*;

public class poolDemo1 {

    public static void main(String[] args) {

        System.out.println(Runtime.getRuntime().availableProcessors());//获取cpu的核数
        ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(
                3,
                5,
                3,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),//线程等待的最大数量
                Executors.defaultThreadFactory(),//默认线程工厂
                //第一种拒绝策略，抛出异常
                new ThreadPoolExecutor.DiscardOldestPolicy()//等待队列满了,就会和最早进入线程池的线程进行竞争，如果竞争成功就成功，失败就抛弃任务，不会抛出异常，是DiscardPolicy的一种优化策略
        );

        try {
            for (int i = 0; i < 13; i++) {
                threadPoolExecutor.execute(()->{
                    System.out.println(Thread.currentThread().getName()+" ok");
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            threadPoolExecutor.shutdown();
        }
    }
}
