package com.learn.Creational.ObjectPool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Supplier;

public class Pool<T extends Poolable> {

    int size;
    BlockingQueue<T> pool;

    public Pool(int size, Supplier<T> supplier){
        this.size = size;
        pool = new LinkedBlockingQueue<>(size);
        for(int i=0;i<size;i++){
            pool.offer(supplier.get());
        }
    }

    public T get(){
        try {
            return pool.take();
        }catch (InterruptedException e){
            System.out.println("Interrupted Exception while GET");
        }
        return null;
    }

    public void offer(T obj){
        try {
            obj.reset();
            pool.put(obj);
        } catch (InterruptedException e) {
            System.out.println("Interrupted Exception while OFFER");
        }
    }

}
