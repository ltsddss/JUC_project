package com.lts.main1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class source{
    private int number=1;
    private Lock lock=new ReentrantLock();

//    监视器
    private Condition condition1=lock.newCondition();
    private Condition condition2=lock.newCondition();
    private Condition condition3=lock.newCondition();

    public void printA() throws InterruptedException {
        lock.lock();
        try {
            while (number!=1){
                condition1.await();
            }
            number=2;

            System.out.println(Thread.currentThread().getName()+"aaaaaa");

//            唤醒condition2
            condition2.signal();
        }
        finally {
            lock.unlock();
        }
    }
    public void printB() throws InterruptedException {
        lock.lock();
        try {
            while (number!=2){
                condition2.await();
            }
            number=3;

            System.out.println(Thread.currentThread().getName()+"bbbbbbb");

//            唤醒condition2
            condition3.signal();
        }
        finally {
            lock.unlock();
        }
    }
    public void printC() throws InterruptedException {
        lock.lock();
        try {
            while (number!=3){
                condition3.await();
            }
            number=1;

            System.out.println(Thread.currentThread().getName()+"cccccc");

//            唤醒condition2
            condition1.signal();
        }
        finally {
            lock.unlock();
        }
    }
}

public class sunxu {

    public static void main(String[] args) {
        source source=new source();
        new Thread(()->{
            try {
                for(int i=0;i<10;i++)
                    source.printA();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"aaaa").start();
        new Thread(()->{
            try {
                for(int i=0;i<10;i++)
                    source.printB();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"bbbbb").start();

        new Thread(()->{
            try {
                for(int i=0;i<10;i++)
                    source.printC();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"ccccc").start();

    }
}
