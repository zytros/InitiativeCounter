package com.inCounter.application;

import com.inCounter.core.ServerListenerThread;
import com.inCounter.shared.config.Configuration;
import com.inCounter.shared.util.IllegalMessageException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Scanner;

public class InputManager {
    private final static Logger LOGGER = LoggerFactory.getLogger(InputManager.class);
    private DataBuffer dataBuffer;
    private Configuration configuration;
    private ServerListenerThread serverListenerThread;
    int id;

    public InputManager(Configuration configuration){
        this.configuration = configuration;
        this.dataBuffer = new DataBuffer();
        this.id = 0;

    }


    /**
     * decodes incoming messages and responds
     * @param message incoming message
     * @return response
     * @throws IllegalMessageException when message is invalid
     */

    public synchronized String readMessageAndRespond(String message)throws IllegalMessageException{
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
        if(frags.get(0).equals(configuration.getDisplay())){ //message comes from display, requesting data
            if(dataBuffer.hasData()){
                return dataBuffer.getBuffer();
            }
            return configuration.getNoData();
        }else if(frags.get(0).equals(configuration.getUserEnd())){//message from userEnd, write data in temp mem
            try {
                int id = Integer.parseInt(frags.get(1));
                String method = frags.get(2);
                String value = frags.get(3);

                if(method.equals(configuration.getServerShutdown())){
                    serverListenerThread.serverShutdown(value);
                    return configuration.getPosResponse();
                }if(method.equals(configuration.getGetId())){
                    return getId();
                }

                Message msg = new Message(id, method, value);
                dataBuffer.append(msg);

            } catch (Exception e) {
                LOGGER.error("Invalid Message to save", e);
                return configuration.getError();
            }
            return configuration.getPosResponse();

        }else{
            throw new IllegalMessageException("Message has invalid sender");
        }
    }

    public void setServerListenerThread(ServerListenerThread serverListenerThread){
        this.serverListenerThread = serverListenerThread;
    }

    private String getId(){
        return Integer.toString(++id);
    }

}
