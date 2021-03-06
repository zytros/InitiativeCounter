package com.inCounter.core;

import com.inCounter.Server;
import com.inCounter.application.InputManager;
import com.inCounter.shared.config.Configuration;
import com.inCounter.shared.util.IllegalMessageException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ConnectionWorkerThread extends Thread{
    private Socket socket;
    private final static Logger LOGGER = LoggerFactory.getLogger(Server.class);
    private InputManager inputManager;
    private Configuration configuration;

    public ConnectionWorkerThread(Socket socket, InputManager inputManager, Configuration configuration){
        this.socket = socket;
        this.inputManager = inputManager;
        this.configuration = configuration;
    }

    @Override
    public void run() {
        LOGGER.info("New Connection");
        InputStream inputStream = null;
        DataOutputStream outputStream = null;
        try {
            inputStream = socket.getInputStream();
            outputStream = new DataOutputStream(socket.getOutputStream());


            DataInputStream input = new DataInputStream(inputStream);
            String message = input.readUTF();


            String response = null;
            try {
                response = inputManager.readMessageAndRespond(message);
            } catch (IllegalMessageException e) {
                response = "IllegalMessageException :: " + e ;
                LOGGER.error("IllegalMessageException :: ", response);
            }
            outputStream.writeUTF(response);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {}
            }if(outputStream != null){
                try {
                    outputStream.close();
                } catch (IOException e) {}
            }if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {}
            }
        }
    }
}
