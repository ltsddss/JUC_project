package com.lts.Function;

import java.util.function.Consumer;

//消费接口，只有输入，没有返回值
public class ConsumerDemo {
    public static void main(String[] args) {
//        Consumer<String> consumer=new Consumer<String>() {
//            @Override
//            public void accept(String o) {
//                System.out.println(o);
//            }
//        };

        Consumer<String> consumer=(str)->{
            System.out.println(str);
        };
        consumer.accept("asdsadsadsdsadsad");
    }
}
