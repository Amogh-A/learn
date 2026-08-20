package com.learn.Creational.Prototype;


public class General extends PrototypeUnit{

    int wifes;

    public General(String Id, String name, String type, String color, int kills) {
        super(Id, name, type, color, kills);
    }

    @Override
    void resetData() {
        throw new UnsupportedOperationException("Reset not allowed for General");
    }

    @Override
    public PrototypeUnit clone() throws CloneNotSupportedException{
        throw new CloneNotSupportedException("Cloning not supported for General");
    }
}
