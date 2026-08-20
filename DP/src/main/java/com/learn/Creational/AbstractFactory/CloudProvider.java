package com.learn.Creational.AbstractFactory;

public interface CloudProvider {
    Compute getCompute();
    Storage getStorage();
}
