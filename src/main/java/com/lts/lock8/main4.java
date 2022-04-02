package com.lts.lock8;

import java.util.concurrent.TimeUnit;

class Test4{
    public static synchronized void sendmsg() throws InterruptedException {
        TimeUnit.SECONDS.sleep(4);
        System.out.println("发消息");
    }
    public synchronized void call() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        System.out.println("打电话");
    }
}

public class main4 {
    public static void main(String[] args) {
        Test4 test3=new Test4();
        Test4 test4=new Test4();
        new Thread(()->{
            try {
                test3.sendmsg();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        },"aa").start();

        new Thread(()->{
            try {
                test4.call();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"bb").start();
    }
}
