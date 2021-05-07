package core;

import com.inCounter.application.Message;
import com.inCounter.shared.config.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;

public class MessageSender extends Thread{
    Configuration configuration;
    Message message;

    private final static Logger LOGGER = LoggerFactory.getLogger(MessageSender.class);

    public MessageSender(Configuration configuration, Message message){
        this.configuration = configuration;
        this.message = message;
    }

    @Override
    public void run() {
        String call = configuration.getUserEnd() + " " + message;
        String response = null;

        try {
            Socket client = new Socket(configuration.getHost(), configuration.getPort());
            DataOutputStream outputStream = new DataOutputStream(client.getOutputStream());
            outputStream.writeUTF(call);

            DataInputStream inputStream = new DataInputStream(client.getInputStream());
            response = inputStream.readUTF();


            client.close();

        } catch (ConnectException e){
            LOGGER.error("no connection possible, try again", e);
        } catch (IOException e) {
            LOGGER.error("IO", e);
        }


        System.out.println("running");
    }
}
