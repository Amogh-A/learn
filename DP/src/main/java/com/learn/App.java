package com.learn;

import com.learn.Creational.*;
import com.learn.Creational.AbstractFactory.AWS;
import com.learn.Creational.AbstractFactory.CloudProvider;
import com.learn.Creational.AbstractFactory.Google;
import com.learn.Creational.Factory.AWSFactory;
import com.learn.Creational.Factory.Factory;
import com.learn.Creational.Factory.TwilioFactory;
import com.learn.Creational.ObjectPool.Pool;
import com.learn.Creational.ObjectPool.Writer;
import com.learn.Creational.Prototype.General;
import com.learn.Creational.Prototype.PrototypeUnit;
import com.learn.Creational.Prototype.Swordsman;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception {
        System.out.println( "Hello World!" );

        //Behavioural

        //1) Singleton:

        Singleton singleton = Singleton.getInstance();
        singleton.printClass();

        //2) Builder:
        Builder builder = Builder.builder()
                .id(123)
                .name("Amogh")
                .address("Banashandsfadfadsfsdakari")
                .active(Boolean.TRUE)
                .build();

        System.out.println(builder.toString());

        //3) Simple Factory:

        SimpleFactory simpleFactory = new SimpleFactory();
        Sort sort = simpleFactory.getSort(SortType.BUBBLE);
        sort.sort();
        sort = simpleFactory.getSort(SortType.HEAP);
        sort.sort();

        //4)Factory:
        Factory factory = new AWSFactory();
        factory.notifyUser();
        factory = new TwilioFactory();
        factory.notifyUser();

        //5) Abstract Factory
        CloudProvider cloudProvider = new AWS();
        cloudProvider.getCompute().compute();
        cloudProvider.getStorage().store();

        cloudProvider = new Google();
        cloudProvider.getCompute().compute();
        cloudProvider.getStorage().store();


        //6) Prototype

        Swordsman swordsman1 = new Swordsman("abc", "Kang", "Swordsman", "Asian", 100);
        swordsman1.setSwords(12);
        System.out.println(swordsman1);
        PrototypeUnit swordsman2 = swordsman1.clone();
        System.out.println(swordsman2);

        try {
            General general = new General("abc", "Hong", "General", "Asian", 100);
            general.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Clone Not Supported Exception Caught");
        }

        //7) Object Pool
        Pool<Writer> pool = new Pool<>(5, Writer::new);

        for(int i=0;i<10;i++){
            Writer writer = pool.get();
            writer.write();
            pool.offer(writer);
        }



    }
}
