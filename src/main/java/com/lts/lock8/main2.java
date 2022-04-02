package com.lts.lock8;

class Test2{
    private synchronized void sendmsg(){
        System.out.println("发消息");
    }

    private synchronized void call(){
        System.out.println("打电话");
    }
}

public class main2 {
    public static void main(String[] args) {

    }
}
