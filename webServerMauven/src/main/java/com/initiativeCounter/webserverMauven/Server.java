package com.initiativeCounter.webserverMauven;

import com.initiativeCounter.webserverMauven.config.Configuration;
import com.initiativeCounter.webserverMauven.config.ConfigurationManager;

/**
 *
 * Driver Class for the server
 *
 */
public class Server {
    public static void main(String args[]){

        System.out.println("Server started...");

        ConfigurationManager.getInstance().loadConfigurationFile("webServerMauven/src/main/resources/http.json");
        Configuration conf = ConfigurationManager.getInstance().getCurrentConfiguration();

        System.out.printf("Using Port: %d\nUsing WebRoot: %s\n", conf.getPort(), conf.getWebroot());

    }
}
