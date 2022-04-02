package com.lts.tvolatile;

//volatile不保证原子性
public class vvolatile {

    private volatile static int num=0;

/**当写入synchroized锁的时候,add方法是可以保证原子性的
 * 但是当使用volatile的时候就不会保证原子性
 */
    private static void add(){
        num++;
    }
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    add();
                }
            }).start();
        }

        /**
         * Thread.yield() 方法，使当前线程由执行状态，变成为就绪状态，让出CPU，在下一个线程执行时候，此线程有可能被执行，也有可能没有被执行。
         */
        while (Thread.activeCount()>2){
            Thread.yield();//线程让步
        }
        System.out.println(num);
    }
}
