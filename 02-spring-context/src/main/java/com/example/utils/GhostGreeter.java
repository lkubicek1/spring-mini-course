package com.example.utils;

public class GhostGreeter {

    private final String messageTemplate;

    public GhostGreeter(String messageTemplate) {
        this.messageTemplate = messageTemplate;
    }

    public String greet(String name) {
        return String.format(messageTemplate, name);
    }
}
