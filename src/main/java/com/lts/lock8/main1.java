package com.lts.lock8;

import java.util.concurrent.TimeUnit;

class Test1{
    public synchronized void sendmsg(){
        System.out.println("发消息");
    }
    public synchronized void call(){
        System.out.println("打电话");
    }

    public void hello(){
        System.out.println("hello");
    }
}

public class main1 {
    public static void main(String[] args) throws InterruptedException {
        Test1 test1=new Test1();
        Test1 test2=new Test1();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            test1.sendmsg();
        },"aa").start();

        TimeUnit.SECONDS.sleep(1);
        new Thread(()->{
            test2.call();
        },"bb").start();
    }
}
