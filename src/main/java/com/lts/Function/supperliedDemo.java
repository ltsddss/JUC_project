package com.lts.Function;

import java.util.function.Supplier;

// 供给型接口，没有输入，只有返回值
public class supperliedDemo {
    public static void main(String[] args) {
//        Supplier<Integer> supplier=new Supplier<Integer>() {
//            @Override
//            public Integer get() {
//                return 12323312;
//            }
//        };

        Supplier<Integer> supplier=()->{
          return 213213213;
        };

        System.out.println(supplier.get());
    }
}
