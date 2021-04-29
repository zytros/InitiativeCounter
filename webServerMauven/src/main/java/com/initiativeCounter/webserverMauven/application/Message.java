package com.initiativeCounter.webserverMauven.application;

public class Message {
    final int id;
    final boolean initiative;
    final int value;

    public Message(int id, boolean initiative, int value) {
        this.id = id;
        this.initiative = initiative;
        this.value = value;
    }

    @Override
    public String toString() {
        String str = Integer.toString(id) + " " +
                Boolean.toString(initiative) + " " +
                Integer.toString(value);
        return str;
    }
}
