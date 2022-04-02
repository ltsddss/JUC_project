package com.lts.main;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class source{
    private int number=0;
    Lock lock=new ReentrantLock();

    Condition condition=lock.newCondition();

    public void incr() throws InterruptedException {
        lock.lock();
        try {
            while (number!=0){
                condition.await();
            }
            number++;

            System.out.println(Thread.currentThread().getName()+"::"+number);

            condition.signalAll();
        }
        finally {
            lock.unlock();
        }
    }
    public void decr() throws InterruptedException {
        lock.lock();
        try {
            while (number!=1){
                condition.await();
            }
            number--;

            System.out.println(Thread.currentThread().getName()+"::"+number);

            condition.signalAll();
        }
        finally {
            lock.unlock();
        }
    }
}

public class main {
    public static void main(String[] args) {

        source s=new source();
        new Thread(()->{
            try{
                for(int i=0;i<10;i++)
                    s.incr();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"aa").start();
        new Thread(()->{
            try{
                for(int i=0;i<10;i++)
                    s.decr();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"bb").start();
        new Thread(()->{
            try{
                for(int i=0;i<10;i++)
                    s.incr();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"cc").start();
        new Thread(()->{
            try{
                for(int i=0;i<10;i++)
                    s.decr();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"dd").start();
    }
}
