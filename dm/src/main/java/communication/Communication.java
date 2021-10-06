package communication;


import com.inCounter.application.Message;
import com.inCounter.shared.config.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Communication {
    private final int id = 0;
    private final Configuration configuration;
    private final static Logger LOGGER = LoggerFactory.getLogger(Communication.class);

    public Communication(Configuration configuration){
        this.configuration = configuration;
    }

    public void sendMessage(String method, String value){
        MessageSender messageSender = new MessageSender(new Message(id, method, value), configuration);
        Thread t = new Thread(messageSender);
        t.start();
        try {
            t.join();
        }catch (InterruptedException e){
            LOGGER.error("Joining error of Message Sender", e);
        }
    }

    public void sendMessage(String method, String value, String target){
        MessageSender messageSender = new MessageSender(new Message(id, method, value), configuration, target);
        Thread t = new Thread(messageSender);
        t.start();
        try {
            t.join();
        }catch (InterruptedException e){
            LOGGER.error("Joining error of Message Sender", e);
        }
    }
}
