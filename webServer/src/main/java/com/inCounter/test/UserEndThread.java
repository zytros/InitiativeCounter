package com.inCounter.test;

import com.inCounter.application.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;

public class UserEndThread extends Thread{

    private final static Logger LOGGER = LoggerFactory.getLogger(UserEndThread.class);

    @Override
    public void run() {

        Message msg = new Message(Integer.parseInt(Thread.currentThread().getName()), "fegit", "50");

        String call = "userEnd " + msg;

        try {
            //Socket client = new Socket("localhost", 8080);
            Socket client = new Socket("srab.duckdns.org", 25565);
            DataOutputStream outputStream = new DataOutputStream(client.getOutputStream());
            outputStream.writeUTF(call);

            DataInputStream inputStream = new DataInputStream(client.getInputStream());
            LOGGER.info(inputStream.readUTF());

            client.close();

            //LOGGER.info("Client: Client shutdown");
        } catch (ConnectException e){
            LOGGER.error("no connection possible, try again", e);
        } catch (IOException e) {
            LOGGER.error("IO", e);
        }
    }
}
