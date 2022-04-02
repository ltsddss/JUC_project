package com.lts.forkJoin;


import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

//这个东西和算法的分而治之很像，没有多大的用处
public class forkjoin extends RecursiveTask<Long> {

    private Long start;

    private Long end;

    private Long temp=10000L;

    public forkjoin(Long start, Long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {

        if(end-start<temp){
            Long sum=0L;

            for(Long i=start;i<=end;i++){
                sum+=i;
            }
            return sum;
        }
        else {
            //分支计算
            Long midle=(start+end)/2;

            forkjoin forkjoin=new forkjoin(start,midle);

            forkjoin.fork();

            forkjoin forkjoin1=new forkjoin(midle+1,end);

            forkjoin1.fork();

            return forkjoin.join()+forkjoin1.join();
        }
    }
}
