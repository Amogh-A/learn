package com.learn.Creational.Factory;

public class Twilio implements MessageInterface{
    @Override
    public void sendMessage() {
        System.out.println("Message Sent through Twilio");
    }
}
