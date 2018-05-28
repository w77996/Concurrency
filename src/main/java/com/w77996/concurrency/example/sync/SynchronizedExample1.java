package com.w77996.concurrency.example.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class SynchronizedExample1 {

    public void test1(int j){
        synchronized (this){
            for (int i = 0; i < 10; i++) {
                log.info("test1 - {} -{}",i,j);
            }
        }
    }

    public synchronized  void test2(){
        for (int i = 0; i < 10; i++) {
            log.info("test2 - {}",i);
        }
    }

    public static void main(String[] args){
        SynchronizedExample1 synchronizedExample1 = new SynchronizedExample1();
        SynchronizedExample1 synchronizedExample2 = new SynchronizedExample1();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(()->{
            synchronizedExample1.test1(1);
        });
        executorService.execute(()->{
            synchronizedExample2.test1(2);
        });
    }
}
