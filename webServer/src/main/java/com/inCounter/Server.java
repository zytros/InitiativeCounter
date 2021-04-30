package com.inCounter;

import com.inCounter.core.ServerListenerThread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;

public class Server {
    private final static Logger LOGGER = LoggerFactory.getLogger(Server.class);

    public static void main(String args[]){
        LOGGER.info("Server starting...");

        int port = 8080;

        ServerListenerThread serverListenerThread = null;
        try {
            serverListenerThread = new ServerListenerThread(port);
            serverListenerThread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
