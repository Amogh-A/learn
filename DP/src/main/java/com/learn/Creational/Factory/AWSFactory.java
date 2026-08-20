package com.learn.Creational.Factory;

public class AWSFactory implements Factory{
    @Override
    public MessageInterface getMessageInterfact() {
        return new AWS();
    }
}
