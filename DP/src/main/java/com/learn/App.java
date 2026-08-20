package com.learn;

import com.learn.Creational.*;
import com.learn.Creational.AbstractFactory.AWS;
import com.learn.Creational.AbstractFactory.CloudProvider;
import com.learn.Creational.AbstractFactory.Google;
import com.learn.Creational.Factory.AWSFactory;
import com.learn.Creational.Factory.Factory;
import com.learn.Creational.Factory.TwilioFactory;

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
        factory.getMessageInterfact().sendMessage();
        factory = new TwilioFactory();
        factory.getMessageInterfact().sendMessage();

        //5) Abstract Factory
        CloudProvider cloudProvider = new AWS();
        cloudProvider.getCompute().compute();
        cloudProvider.getStorage().store();

        cloudProvider = new Google();
        cloudProvider.getCompute().compute();
        cloudProvider.getStorage().store();

    }
}
