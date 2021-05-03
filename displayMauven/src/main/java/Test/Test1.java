package Test;


import communication.Caller;
import communication.Communication;
import communication.SharedQueue;
import config.Configuration;
import config.ConfigurationManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Test1 {

    private final static Logger LOGGER = LoggerFactory.getLogger(Test1.class);

    public static void main(String[] args) throws InterruptedException {

        ConfigurationManager.getInstance().loadConfigurationFile("displayMauven/src/main/resources/config.json");
        Configuration conf = ConfigurationManager.getInstance().getCurrentConfiguration();

        SharedQueue show = new SharedQueue();
        show.q.add(new Caller("1","startprog",null));
        Communication test = new Communication(show, conf);
        Thread t = new Thread(test);
        t.start();



        for(int i = 0; i < 100;) {

            if (!show.isEmpty()) {
                i++;
                LOGGER.info("working");
                Caller out = show.poll();
                LOGGER.info(out.getId() + ", " + out.getMethod() + ", " + out.getValue());
            }
        }
    }
}
