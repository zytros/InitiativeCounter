package com.initiativeCounter.webserverMauven.application;

import java.util.ArrayList;

public class DataBuffer {
    ArrayList buffer;

    public DataBuffer() {
        this.buffer = new ArrayList<Message>();
    }

    public synchronized void append(Message msg){

    }

    public synchronized String getBuffer(){
        return "";
    }
}
