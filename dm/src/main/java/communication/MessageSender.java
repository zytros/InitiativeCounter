package communication;

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

    final Message message;
    Configuration configuration;
    private final static Logger LOGGER = LoggerFactory.getLogger(MessageSender.class);
    String target;
    final boolean ret;


    public MessageSender(Message message, Configuration configuration){
        this.message = message;
        this.configuration = configuration;
        ret = false;
    }

    public MessageSender(Message message, Configuration configuration, String target){
        this.message = message;
        this.configuration = configuration;
        this.target = target;
        ret = true;
    }


    @Override
    public void run() {

        String call = "dm" + " " + message;
        String response = null;

        try {
            Socket client = new Socket(configuration.getHost(), configuration.getPort());
            DataOutputStream outputStream = new DataOutputStream(client.getOutputStream());
            outputStream.writeUTF(call);

            DataInputStream inputStream = new DataInputStream(client.getInputStream());
            response = inputStream.readUTF();

            target = response;

            client.close();

        } catch (ConnectException e){
            LOGGER.error("no connection possible, try again", e);
        } catch (IOException e) {
            LOGGER.error("IO", e);
        }


    }

}
