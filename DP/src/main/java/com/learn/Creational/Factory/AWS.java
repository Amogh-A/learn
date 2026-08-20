package com.learn.Creational.Factory;

public class AWS implements MessageInterface{
    @Override
    public void sendMessage() {
        System.out.println("Message Sent through AWS");
    }
}
