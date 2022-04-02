package com.lts.Function;

import java.util.function.Function;
//创建一个函数式接口
//函数式接口：在接口中只有一个方法
public class FunctionDemo {
    public static void main(String[] args) {
//        这个函数的作用是输入一个str返回一个str
//        Function function= new Function<String,String>() {
//            @Override
//            public String apply(String o) {
//                return o;
//            }
//        };

        Function function=(str)->{
            return str;
        };
        System.out.println(function.apply("asd"));
    }
}
