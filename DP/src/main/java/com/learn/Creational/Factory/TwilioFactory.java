package com.learn.Creational.Factory;

public class TwilioFactory implements Factory{
    @Override
    public MessageInterface getMessageInterfact() {
        return new Twilio();
    }
}
