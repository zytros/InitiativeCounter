package com.inCounter.core;


import com.inCounter.Server;
import com.inCounter.application.InputManager;
import com.inCounter.util.IllegalMessageException;
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


    public ConnectionWorkerThread(Socket socket, InputManager inputManager){
        this.socket = socket;
        this.inputManager = inputManager;

    }

    @Override
    public void run() {
        //LOGGER.info("New Connection");
        InputStream inputStream = null;
        DataOutputStream outputStream = null;
        try {
            inputStream = socket.getInputStream();
            outputStream = new DataOutputStream(socket.getOutputStream());


            DataInputStream input = new DataInputStream(inputStream);
            String message = input.readUTF();
            //LOGGER.info("recieved message", message);


            String response = null;
            try {
                response = inputManager.readMessageAndRespond(message);
            } catch (IllegalMessageException e) {
                response = "IllegalMessageException :: " + e.toString() ;
                LOGGER.error("IllegalMessageException :: ", e);
            }
            outputStream.writeUTF(response);

            //LOGGER.info("responded");

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
