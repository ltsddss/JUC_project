package com.lts.comdownlatch;

import java.util.concurrent.CountDownLatch;

public class condownlatch {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch=new CountDownLatch(6);

        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"Go out");
                //countDownLatch减一
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }

//        当countDownLatch归零的时候才会执行下一部分代码
        countDownLatch.await();
        System.out.println("close door");
    }
}
