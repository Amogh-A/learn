package com.learn.Creational.AbstractFactory;

public class Google implements CloudProvider{
    @Override
    public Compute getCompute() {
        return new GoogleCompute();
    }

    @Override
    public Storage getStorage() {
        return new GoogleStorage();
    }
}
