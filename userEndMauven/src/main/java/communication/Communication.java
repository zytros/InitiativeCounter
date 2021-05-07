package communication;

import com.inCounter.application.Message;
import com.inCounter.shared.config.Configuration;
import core.MessageSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Communication {
    private Configuration configuration;
    private final int id;
    private final static Logger LOGGER = LoggerFactory.getLogger(Communication.class);

    public Communication(Configuration configuration){
        this.configuration = configuration;
        String response = "";
        try {
            String call = configuration.getUserEnd() + " 0 " + configuration.getGetId() + " 0";
            Socket client = new Socket(configuration.getHost(), configuration.getPort());
            DataOutputStream outputStream = new DataOutputStream(client.getOutputStream());
            outputStream.writeUTF(call);
            DataInputStream inputStream = new DataInputStream(client.getInputStream());
            response = inputStream.readUTF();
            client.close();
        } catch (IOException e) {
            LOGGER.error("IO", e);
        }
        LOGGER.info("Communication has id " + response);
        this.id = Integer.parseInt(response);
    }

    public void sendMessage(String method, String value){
        MessageSender messageSender = new MessageSender(configuration, new Message(id, method, value));
        Thread t = new Thread(messageSender);
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            LOGGER.error("Error Joining Message Thread", e);
        }
    }

}
