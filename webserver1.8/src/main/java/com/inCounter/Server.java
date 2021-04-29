package com.inCounter;

import com.inCounter.config.ConfigurationManager;

/**
 *
 * Driver Class for the server
 * Dont use, its trash
 *
 */
public class Server {
    public static void main(String args[]){

        System.out.println("Server started...");

        ConfigurationManager.getInstance().loadConfigurationFile("webServerMauven/src/main/resources/http.json");

    }
}
