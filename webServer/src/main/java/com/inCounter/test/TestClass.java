package com.inCounter.test;


import com.inCounter.application.DataBuffer;
import com.inCounter.application.Message;

import java.util.ArrayList;
import java.util.Random;

public class TestClass {
    private static int i;
    public static void main(String args[]){

        Random rnd = new Random();
        ArrayList<Thread> threads = new ArrayList<>();
        for(int i = 0; i < 20; i++){
            int dec = rnd.nextInt(10);
            if(dec < 8){
                Thread t = spawnUserEnd();
                t.start();
                threads.add(t);
            }else{
                Thread t = spawnDisplay();
                t.start();
                threads.add(t);
            }
        }

        for (Thread t : threads){
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static Thread spawnUserEnd(){
        UserEndThread userEndThread = new UserEndThread();
        Thread t = new Thread(userEndThread);
        t.setName(incr());
        return t;
    }

    public static Thread spawnDisplay(){
        DisplayThread displayThread = new DisplayThread();
        Thread t = new Thread(displayThread);
        t.setName(incr());
        return t;
    }

    public static synchronized String incr(){
        return Integer.toString(i++);
    }
}
