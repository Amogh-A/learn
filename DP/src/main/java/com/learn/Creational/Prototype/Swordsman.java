package com.learn.Creational.Prototype;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@ToString(callSuper = true)
@AllArgsConstructor
@Data
public class Swordsman extends PrototypeUnit{


    int swords;

    public Swordsman(String Id, String name, String type, String color, int kills) {
        super(Id, name, type, color, kills);
    }

    @Override
    void resetData() {
        this.swords = 0;
    }
}
