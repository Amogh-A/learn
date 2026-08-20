package com.learn.Creational.Factory;

public class TwilioFactory extends Factory{
    @Override
    public MessageInterface getMessageInterfact() {
        return new Twilio();
    }
}
