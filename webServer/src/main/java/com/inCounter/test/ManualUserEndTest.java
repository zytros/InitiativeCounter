package com.inCounter.test;

public class qManualUserEndTest {
    public static void main(String args[]){
        UserEndThread userEndThread = new UserEndThread();
        Thread t = new Thread(userEndThread);
        t.setName("0");
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
