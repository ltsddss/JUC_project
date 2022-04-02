package com.lts.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class callableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        mycallable my=new mycallable();
        FutureTask futureTask=new FutureTask(my);
        new Thread(futureTask,"a").start();
        new Thread(futureTask,"b").start();

        String o = (String) futureTask.get();

        System.out.println(o);
    }
}

class mycallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("他进来了哦");
        return "1433223";
    }
}
