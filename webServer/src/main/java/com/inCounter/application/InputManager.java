package com.inCounter.application;

import com.inCounter.util.IllegalMessageException;

import java.util.ArrayList;
import java.util.Scanner;

public class InputManager {
    private final String display = "display";
    private final String userEnd = "userEnd";
    DataBuffer dataBuffer;
    public InputManager(){
        dataBuffer = new DataBuffer();
    }

    /**
     * decodes incoming messages and responds
     * @param message incoming message
     * @return response
     * @throws IllegalMessageException when message is invalid
     */

    public synchronized String readMessageAndRespond(String message)throws IllegalMessageException{
        String response = "";
        if(message == null){
            throw new IllegalMessageException("Message == null");
        }
        ArrayList messageFragements = new ArrayList<String>();
        Scanner sc = new Scanner(message);
        while(sc.hasNext()){
            messageFragements.add(sc.next());
        }
        /**
         * message decoding
         */
        if(messageFragements.get(0).equals(display)){ //message comes from display, requesting data
            //TODO
            if(dataBuffer.hasData()){
                return dataBuffer.getBuffer();
            }
            return "noData";
        }else if(messageFragements.get(0).equals(userEnd)){//message from userEnd, write data in temp mem
            //TODO

        }else{
            throw new IllegalMessageException("Message has invalid sender");
        }
        return response;
    }

}
