package com.learn.Creational.Factory;

public abstract class Factory {
    abstract MessageInterface getMessageInterfact();
    public void notifyUser(){
        MessageInterface messageInterface = getMessageInterfact();
        messageInterface.sendMessage();
    }
}