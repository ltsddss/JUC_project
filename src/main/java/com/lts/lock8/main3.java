package com.lts.lock8;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

class Test3{
    public static synchronized void sendmsg() throws InterruptedException {
        TimeUnit.SECONDS.sleep(4);
        System.out.println("发消息");
    }
    public static synchronized void call() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        System.out.println("打电话");
    }

}

public class main3 {

    public static void main(String[] args) {
        Test3 test3=new Test3();
        Test3 test4=new Test3();
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
