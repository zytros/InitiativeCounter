package com.inCounter.application;

import com.inCounter.Server;
import com.inCounter.util.IllegalMessageException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Scanner;

public class InputManager {
    private final static Logger LOGGER = LoggerFactory.getLogger(Server.class);
    private final String display = "display";
    private final String userEnd = "userEnd";
    private final String error = "error";
    private final String posResponse = "OK";
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
        ArrayList<String> frags = new ArrayList<String>();
        Scanner sc = new Scanner(message);
        while(sc.hasNext()){
            frags.add(sc.next());
        }
        /**
         * message decoding
         */
        if(frags.get(0).equals(display)){ //message comes from display, requesting data
            if(dataBuffer.hasData()){
                return dataBuffer.getBuffer();
            }
            return "noData";
        }else if(frags.get(0).equals(userEnd)){//message from userEnd, write data in temp mem
            try {
                int id = Integer.parseInt(frags.get(1));
                String method = frags.get(2);
                String value = frags.get(3);
                Message msg = new Message(id, method, value);
                dataBuffer.append(msg);
            } catch (Exception e) {
                LOGGER.error("Invalid Message to save", e);
                return error;
            }
            return posResponse;

        }else{
            throw new IllegalMessageException("Message has invalid sender");
        }
    }

}
