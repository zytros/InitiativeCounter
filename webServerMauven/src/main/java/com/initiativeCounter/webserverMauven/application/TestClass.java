package com.initiativeCounter.webserverMauven.application;


import java.util.ArrayList;

public class TestClass {
    public static void main(String args[]){
        ArrayList arrayList = new ArrayList<Message>();
        Message m1 = new Message(1, false, 5);
        Message m2 = new Message(2, true, 55);
        Message m3 = new Message(3, false, 5);

        arrayList.add(m1);
        arrayList.add(m2);
        arrayList.add(m3);

        String str = arrayList.toString();
        System.out.println(str);
    }
}
