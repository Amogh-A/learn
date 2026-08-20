package com.learn.Creational.AbstractFactory;

public class EC2 implements Compute{
    @Override
    public void compute() {
        System.out.println("EC2 Compute");
    }
}
