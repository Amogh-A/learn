package com.learn.Creational.AbstractFactory;

public class GoogleStorage implements Storage{
    @Override
    public void store() {
        System.out.println("Google Storage");
    }
}
