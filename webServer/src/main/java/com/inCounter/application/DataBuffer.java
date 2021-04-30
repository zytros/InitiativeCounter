package com.inCounter.application;

import java.util.ArrayList;

public class DataBuffer {
    private ArrayList buffer;

    public DataBuffer() {
        this.buffer = new ArrayList<Message>();
    }

    public synchronized void append(Message msg){
        buffer.add(msg);
    }

    public synchronized String getBuffer(){
        String str = buffer.toString();
        str = str.substring(1, str.length() - 1);
        buffer.clear();
        return str;
    }
    public synchronized boolean hasData(){
        if(buffer.size() == 0){
            return false;
        }
        return true;
    }
}
