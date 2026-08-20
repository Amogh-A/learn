package com.learn.Creational;

import java.util.function.Supplier;

public enum SortType{
    BUBBLE(BubbleSort::new),
    HEAP(HeapSort::new);

    private final Supplier<Sort> factory;


    SortType(Supplier<Sort> factory){
        this.factory = factory;
    }

    Sort create(){
        return this.factory.get();
    }
}
