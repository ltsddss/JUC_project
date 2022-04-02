package com.lts.unsafe;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class setTest {
    public static void main(String[] args) {
        Set<String> set=new HashSet<>();

        for(int i=0;i<30;i++){
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(set);
            },String.valueOf(i)).start();
        }
    }
}
