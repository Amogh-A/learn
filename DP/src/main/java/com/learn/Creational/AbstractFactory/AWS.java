package com.learn.Creational.AbstractFactory;

public class AWS implements CloudProvider{
    @Override
    public Compute getCompute() {
        return new EC2();
    }

    @Override
    public Storage getStorage() {
        return new S3();
    }
}
