package com.lts.Function;

import java.util.function.Predicate;

public class PredicateDemo {
    public static void main(String[] args) {
//        输入一个参数返回一个布尔类型的值
//        Predicate<String> predicate=new Predicate<String>() {
//            @Override
//            public boolean test(String str) {
//                return str.isEmpty();
//            }
//        };

        Predicate<String> predicate=(str)->{
            return str.isEmpty();
        };

        System.out.println(predicate.test(""));
    }
}
