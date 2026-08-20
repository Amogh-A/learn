package com.learn.Creational.Prototype;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public abstract class PrototypeUnit implements Cloneable{

    String Id;
    String name;
    String type;
    String color;
    int kills;

    @Override
    public PrototypeUnit clone() throws CloneNotSupportedException{
            PrototypeUnit prototypeClass = (PrototypeUnit) super.clone();
            prototypeClass.initialize();
            return prototypeClass;
    }

    private void initialize(){
        this.setId(UUID.randomUUID().toString());
        this.setKills(0);
        resetData();
    }

    abstract void resetData();
}
