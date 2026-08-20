package com.learn.Creational.ObjectPool;

import lombok.NoArgsConstructor;

import java.util.concurrent.TimeUnit;

@NoArgsConstructor
public class Writer extends Poolable {

    public void write() throws InterruptedException {
        Thread.sleep((long) (Math.random() * 1001) + 1000);
        System.out.println("Writing");
    }


    @Override
    public void reset() {
        System.out.println("Reset Method called");
    }
}
