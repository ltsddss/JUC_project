package com.lts.lock8;


//Lock 8锁问题
import java.util.concurrent.TimeUnit;

class Test{
    public synchronized void sendmsg(){
        System.out.println("发消息");
    }
    public synchronized void call(){
        System.out.println("打电话");
    }
}

public class main {
    public static void main(String[] args) throws InterruptedException {
        Test test=new Test();

        new Thread(()->{
           test.sendmsg();
        },"bb").start();

        TimeUnit.SECONDS.sleep(4);

        new Thread(()->{
            test.call();
        },"bb").start();
    }
}
