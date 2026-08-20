package com.learn.Creational;

import javax.naming.InvalidNameException;

public class SimpleFactory {

    public Sort getSort(SortType sortType) throws InvalidNameException {
        return sortType.create();
    }

}




class BubbleSort implements Sort{

    @Override
    public void sort() {
        System.out.println("Bubble Sort");
    }
}

class HeapSort implements Sort{

    @Override
    public void sort() {
        System.out.println("Heap Sort");
    }
}

