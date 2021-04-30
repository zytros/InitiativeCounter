package com.inCounter.test;

public class ManualDisplayTest {
    public static void main(String args[]){
        DisplayThread displayThread = new DisplayThread();
        Thread t = new Thread(displayThread);
        t.setName("1");
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
