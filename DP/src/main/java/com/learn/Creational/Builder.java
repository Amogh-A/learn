package com.learn.Creational;

import lombok.Data;
import lombok.ToString;
import org.apache.coyote.BadRequestException;

@ToString
public class Builder {
    private int id;
    private String name;
    private String address;
    private Boolean active;


    private Builder(int id, String name, String address, Boolean active){
        this.id = id;
        this.name = name;
        this.address = address;
        this.active = active;
    }

    public static BuilderBuilder builder(){
        return new BuilderBuilder();
    }

    public static class BuilderBuilder{

        int id;
        String name;
        String address;
        Boolean active;

        public BuilderBuilder id(int id) throws Exception {
            if(id<0)
                throw new IllegalStateException("Id cannot be null");
            this.id = id;
            return this;
        }

        public BuilderBuilder name(String name) throws Exception {
            if(name.length()<3)
                throw new IllegalStateException("Named cannot be less than 3 char");
            this.name = name;
            return this;
        }

        public BuilderBuilder address(String address) throws BadRequestException {
            if(address.length()<10)
                throw new BadRequestException("Address cannot be less than 10 char");
            this.address = address;
            return this;
        }

        public BuilderBuilder active(Boolean active){
            this.active = active;
            return this;
        }

        public Builder build(){
            Builder builder = new Builder(this.id, this.name, this.address, this.active);
            return builder;
        }

    }

}

