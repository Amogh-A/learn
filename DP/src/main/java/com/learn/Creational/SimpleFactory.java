package com.learn.Creational;

import javax.naming.InvalidNameException;

public class SimpleFactory {

    public Sort getSort(String name) throws InvalidNameException {
        if("bubble".equals(name))
            return new BubbleSort();
        else if("heap".equals(name))
            return new HeapSort();
        else
            throw new IllegalArgumentException("Invalid Sort Algo Name");
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

