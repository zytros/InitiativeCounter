package com.inCounter;

import com.inCounter.core.ServerListenerThread;

import java.io.IOException;

public class Server {

    private final static Logger LOGGER = LoggerFactory.getLogger(Server.class);

    public static void main(String args[]){
        System.out.println("Server starting...");

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
