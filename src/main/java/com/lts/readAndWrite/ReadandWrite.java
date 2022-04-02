package com.lts.readAndWrite;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadandWrite {
    public static void main(String[] args) {
        myceachLock myceachLock=new myceachLock();
        for (int i = 1; i <=5 ; i++) {
            final int temp=i;
            new Thread(()->{
                myceachLock.putmap(temp+"",temp+"");
            },String.valueOf(i)).start();
        }
        for (int i = 1; i <=5 ; i++) {
            final int temp=i;
            new Thread(()->{
                myceachLock.getmap(temp+"");
            },String.valueOf(i)).start();
        }
    }
}

//自定义读写缓存锁
class myceachLock{
    private Map<String,Object> map=new HashMap<>();

    private ReadWriteLock readWriteLock=new ReentrantReadWriteLock();

    //    写入
    public void putmap(String key,Object value){
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"写入缓存");
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+"写入缓存完成");
        }
        finally {
            readWriteLock.writeLock().unlock();
        }

    }
    //    读出
    public Object getmap(String key){
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"读出缓存");
            Object o= map.get(key);
            System.out.println(Thread.currentThread().getName()+"读出缓存完成");
            return o;
        }
        finally {
            readWriteLock.readLock().unlock();
        }

    }
}

//自定义缓存
class myceach{

    private Map<String,Object> map=new HashMap<>();

//    写入
    public void putmap(String key,Object value){
        System.out.println(Thread.currentThread().getName()+"写入缓存");
        map.put(key,value);
        System.out.println(Thread.currentThread().getName()+"写入缓存完成");
    }
//    读出
    public Object getmap(String key){
        System.out.println(Thread.currentThread().getName()+"读出缓存");
        return map.get(key);
    }
}
