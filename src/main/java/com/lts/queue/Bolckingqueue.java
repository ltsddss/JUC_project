package com.lts.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Bolckingqueue {
    public static void main(String[] args) throws InterruptedException {
        test4();
    }

    /*
     *四组API中第一个，抛出异常
     */
    public static void test1(){
//        在括号中添加参数，表示队列的长度，当添加的对象超出队列的长度之后就会抛出异常
//        Exception in thread "main" java.lang.IllegalStateException: Queue full(队列已满)
        ArrayBlockingQueue arrayBlockingQueue=new ArrayBlockingQueue<>(3);
        arrayBlockingQueue.add("a");
        arrayBlockingQueue.add("b");
        arrayBlockingQueue.add("c");

        System.out.println(arrayBlockingQueue.remove());
        System.out.println(arrayBlockingQueue.remove());
        System.out.println(arrayBlockingQueue.remove());
        System.out.println(arrayBlockingQueue.remove());
    }

    /**
     * 有返回值不抛出异常
     */
    public static void test2(){
        ArrayBlockingQueue arrayBlockingQueue=new ArrayBlockingQueue<>(3);

        System.out.println(arrayBlockingQueue.offer("a"));

        System.out.println(arrayBlockingQueue.offer("b"));
        System.out.println(arrayBlockingQueue.offer("c"));
        System.out.println(arrayBlockingQueue.offer("d"));

        System.out.println("============================");

        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
    }

    /**
     * 阻塞，一直等待
     */
    public static void test3() throws InterruptedException {
        ArrayBlockingQueue arrayBlockingQueue=new ArrayBlockingQueue<>(3);

        arrayBlockingQueue.put("A");
        arrayBlockingQueue.put("b");
        arrayBlockingQueue.put("c");
        System.out.println("===================");

//        弹出队首元素
        System.out.println(arrayBlockingQueue.take());
        System.out.println(arrayBlockingQueue.take());
        System.out.println(arrayBlockingQueue.take());
        System.out.println(arrayBlockingQueue.take());
    }

    /**
     * 阻塞，超时等待
     */
    public static void test4() throws InterruptedException {
        ArrayBlockingQueue arrayBlockingQueue=new ArrayBlockingQueue(3);

        System.out.println(arrayBlockingQueue.offer("a"));
        System.out.println(arrayBlockingQueue.offer("b"));
        System.out.println(arrayBlockingQueue.offer("c"));

//        arrayBlockingQueue.offer("d",2, TimeUnit.SECONDS);
        System.out.println("=======================");
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        arrayBlockingQueue.poll(2,TimeUnit.SECONDS);//超时两秒之后就不会再等待了
    }
}
