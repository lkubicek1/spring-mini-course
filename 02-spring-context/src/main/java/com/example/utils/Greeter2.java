package com.example.utils;

import org.springframework.beans.factory.annotation.Autowired;

public class Greeter2 {
    private final GreeterHelper greeterHelper;

    @Autowired
    public Greeter2(GreeterHelper greeterHelper) {
        this.greeterHelper = greeterHelper;
    }

    public String greet(String name) {
        return greeterHelper.greet(name);
    }
}
