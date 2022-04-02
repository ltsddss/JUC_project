package com.lts.queue;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * 同步队列，队列的大小为一,每次必须等到线程里面的元素被弹出来之后才可以塞入下一个元素
 */
public class synchronizedqueue {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue=new SynchronousQueue<>();

        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName()+"put A");
                blockingQueue.put("A");
                System.out.println(Thread.currentThread().getName()+"put B");
                blockingQueue.put("B");
                System.out.println(Thread.currentThread().getName()+"put C");
                blockingQueue.put("C");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t1").start();

        new Thread(()->{

            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName()+"==>"+blockingQueue.take());
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName()+"==>"+blockingQueue.take());
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName()+"==>"+blockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t2").start();
    }
}
