package com.inCounter.application;


public class TestClass {
    public static void main(String args[]){

        DataBuffer buffer = new DataBuffer();
        Message m1 = new Message(1, "addHP", "10");
        Message m2 = new Message(2, "setInitiative", "76");
        Message m3 = new Message(3, "addItem", "bling");

        buffer.append(m1);
        buffer.append(m2);
        buffer.append(m3);

        String str = buffer.getBuffer();
        System.out.println(str);

        str = buffer.getBuffer();
        System.out.println(str);
    }
}
