package com.lts.unsafe;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

public class main {

    public static void main(String[] args) {
        List<String> list=new CopyOnWriteArrayList<>(new ArrayList<>());

        for (int i = 0; i <=10 ; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }
}
