package com.lts.comdownlatch;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class semaphore {
    public static void main(String[] args) {
//        等待3个线程的信号量，也就是说之后3个位置
        Semaphore semaphore=new Semaphore(3);

        for(int i=0;i<6;i++){
            new Thread(()->{
                try {
//                    线程获得信号
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"得到了信号");
//                    得到线程后线程沉睡两秒
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println(Thread.currentThread().getName()+"释放信号");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
//                    释放信号
                    semaphore.release();
                }
            },String.valueOf(i)).start();
        }
    }
}
