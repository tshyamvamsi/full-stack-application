package com.shyamlearning;

import org.springframework.stereotype.Service;

@Service
public class FooService {

    private final SpringBootExampleApplication.Foo foo;

    public FooService(SpringBootExampleApplication.Foo foo){
        this.foo = foo;
    }

    String getFooName(){
        return foo.name();
    }
}
