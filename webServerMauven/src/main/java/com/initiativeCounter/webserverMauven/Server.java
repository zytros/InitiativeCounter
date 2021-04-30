package com.initiativeCounter.webserverMauven;

import com.initiativeCounter.webserverMauven.config.Configuration;
import com.initiativeCounter.webserverMauven.config.ConfigurationManager;
import com.initiativeCounter.webserverMauven.core.ServerListenerThread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 *
 * Driver Class for the server
 *
 */
public class Server {

    private final static Logger LOGGER = LoggerFactory.getLogger(Server.class);
    public static void main(String args[]){


        LOGGER.info("Server starting...");


        ConfigurationManager.getInstance().loadConfigurationFile("webServerMauven/src/main/resources/http.json");
        Configuration conf = ConfigurationManager.getInstance().getCurrentConfiguration();

        LOGGER.info("Using Port: " + conf.getPort());
        LOGGER.info("Using WebRoot" + conf.getWebroot());

        try {
            ServerListenerThread serverListenerThread = new ServerListenerThread(conf.getPort(), conf.getWebroot());
            serverListenerThread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
