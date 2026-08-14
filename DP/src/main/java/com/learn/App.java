package com.learn;

import com.learn.Creational.*;

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

    }
}
