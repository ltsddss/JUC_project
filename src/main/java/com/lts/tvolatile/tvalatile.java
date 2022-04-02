package com.lts.tvolatile;

import java.util.concurrent.TimeUnit;

//volatile保证可见性
public class tvalatile {

    private static volatile int num=0;
    public static void main(String[] args) {

//        线程获得num之后会一直做循环
        new Thread(new Runnable(){
            @Override
            public void run() {
                while (num==0){

                }
            }
        }).start();
//        主线程停1秒,防止线程读取到num=1
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        输出num
        num=1;
        System.out.println(num);

    }
}
