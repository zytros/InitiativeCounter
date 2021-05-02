package com.inCounter;

import com.inCounter.application.InputManager;
import com.inCounter.config.Configuration;
import com.inCounter.config.ConfigurationManager;
import com.inCounter.core.ServerListenerThread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;

public class Server {
    private final static Logger LOGGER = LoggerFactory.getLogger(Server.class);

    public static void main(String[] args){
        LOGGER.info("Server starting...");

        ConfigurationManager.getInstance().loadConfigurationFile("webServer/src/main/resources/config.json");
        Configuration conf = ConfigurationManager.getInstance().getCurrentConfiguration();
        InputManager inputManager = new InputManager(conf);

        LOGGER.info("Configuration loaded");

        ServerListenerThread serverListenerThread = null;
        try {
            serverListenerThread = new ServerListenerThread(inputManager, conf);
            inputManager.setServerListenerThread(serverListenerThread);
            serverListenerThread.start();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                serverListenerThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


}
