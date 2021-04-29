package com.initiativeCounter.webserverMauven.config;

import com.fasterxml.jackson.databind.JsonNode;
import com.initiativeCounter.webserverMauven.util.Json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ConfigurationManager {

    private static ConfigurationManager myConfigurationManager;
    private static Configuration myCurrentConfiguration;

    private ConfigurationManager(){
    }

    public static ConfigurationManager getInstance(){
        if(myConfigurationManager == null){
            myConfigurationManager = new ConfigurationManager();
        }
        return myConfigurationManager;
    }

    /**
     *
     * Used to load a configuration via filepath
     * @param filepath
     */
    public void loadConfigurationFile(String filepath) {
        FileReader fr = null;
        try {
            fr = new FileReader(filepath);
        } catch (FileNotFoundException e) {
            throw new HttpConfiguratonException(e);
        }
        StringBuffer sb = new StringBuffer();
        int i;
        try {
            while ((i = fr.read()) != -1) {
                sb.append((char) i);
            }
        }catch (IOException e){
            throw new HttpConfiguratonException(e);
        }
        JsonNode conf = null;
        try {
            //conf = Json.parse("true");
            conf = Json.parse(sb.toString());
        } catch (IOException e) {
            throw new HttpConfiguratonException("Error parsing the config file", e);
        }
        try {
            myCurrentConfiguration = Json.fromJson(conf, Configuration.class);
        } catch (IOException e) {
            throw new HttpConfiguratonException("Error parsing the config file internal", e);
        }
    }

    /**
     *
     * Returns the current configuration
     *
     */
    public Configuration getCurrentConfiguration(){
        if(myCurrentConfiguration == null){
            throw new HttpConfiguratonException("No Current Configuration Set.");
        }
        return myCurrentConfiguration;
    }
}
