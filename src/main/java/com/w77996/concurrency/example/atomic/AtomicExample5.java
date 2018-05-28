package com.w77996.concurrency.example.atomic;

import com.w77996.concurrency.annoations.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

@Slf4j
@ThreadSafe
public class AtomicExample5 {
   private static AtomicIntegerFieldUpdater<AtomicExample5> updater = AtomicIntegerFieldUpdater.newUpdater(AtomicExample5.class,"count");

   @Getter
   public volatile int count = 100;

   private static AtomicExample5 atomicExample5 = new AtomicExample5();
   public static void main(String[] args){
        if(updater.compareAndSet(atomicExample5,100,120)){
            log.info("upate success 1 ,{}",atomicExample5.getCount());
        }

        if(updater.compareAndSet(atomicExample5,100,120)){
            log.info("update success 2 {}",atomicExample5.getCount());
        }else{
            log.info("update fail {}",atomicExample5.getCount());
        }
       //log.info("count{}",count);
   }
}
