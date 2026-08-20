package com.learn.Creational.Factory;

public class AWSFactory extends Factory{
    @Override
    public MessageInterface getMessageInterfact() {
        return new AWS();
    }
}
