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
        String[] str_msg = new String[3];
        if(message == null){
            throw new IllegalMessageException("Message == null");
        }
        ArrayList<String> frags = new ArrayList<String>();
        Scanner sc = new Scanner(message);
        while(sc.hasNext()){
            frags.add(sc.next());
        }
        if(frags.size() > 4){
            String frag3 = frags.get(3);
            for(int i = 4; i < frags.size();i++){
                String frag = frags.get(i);
                frag3 = frag3 + " " + frag;
            }
            str_msg[0] = frags.get(1);
            str_msg[1] = frags.get(2);
            str_msg[2] = frag3;
        }else if (frags.size() == 4){
            str_msg[0] = frags.get(1);
            str_msg[1] = frags.get(2);
            str_msg[2] = frags.get(3);
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
                int id = Integer.parseInt(str_msg[0]);
                String method = str_msg[1];
                String value = str_msg[2];

                /**
                 * Commands resolved on Server
                 */
                if(method.equals(configuration.getServerShutdown())){
                    serverListenerThread.serverShutdown(value);
                    return configuration.getPosResponse();
                }

                if(method.equals(configuration.getGetId())){
                    LOGGER.info("Assigned new client ID: " + (this.id + 1));
                    return getId();
                }

                if(method.equals((configuration.getNewSession()))){
                    this.id = 0;
                    LOGGER.info("Reset current Session, set ID to " + this.id);
                    return configuration.getPosResponse();
                }

                /**
                 * Message forwarding
                 */
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
