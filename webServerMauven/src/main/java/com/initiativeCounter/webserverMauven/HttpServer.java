package com.initiativeCounter.webserverMauven;

import com.initiativeCounter.webserverMauven.config.ConfigurationManager;

/**
 *
 * Driver Class for the server
 *
 */
public class HttpServer {
    public static void main(String args[]){

        System.out.println("Server started...");

        ConfigurationManager.getInstance().loadConfigurationFile("src/main/resources/http.json");

    }
}
