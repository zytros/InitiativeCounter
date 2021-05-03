package com.inCounter.test;

public class ManualUserEndTest {
    public static void main(String args[]){
        UserEndThread userEndThread = new UserEndThread();
        Thread t = new Thread(userEndThread);
        t.setName("1");
        t.start();
        UserEndThread userEndThread2 = new UserEndThread();
        Thread t2 = new Thread(userEndThread2);
        t2.setName("2");
        t2.start();
        UserEndThread userEndThread3 = new UserEndThread();
        Thread t3 = new Thread(userEndThread3);
        t3.setName("3");
        t3.start();
        try {
            t.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
