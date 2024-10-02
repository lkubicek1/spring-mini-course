package com.example.utils;

public class GreeterHelper {

    private final String messageTemplate;

    public GreeterHelper(String messageTemplate) {
        this.messageTemplate = messageTemplate;
    }

    public String greet(String name) {
        return String.format(messageTemplate, name);
    }
}
