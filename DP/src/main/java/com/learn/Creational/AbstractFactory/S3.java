package com.learn.Creational.AbstractFactory;

public class S3 implements Storage{
    @Override
    public void store() {
        System.out.println("S3 Storage");
    }
}
