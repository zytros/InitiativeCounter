
import com.inCounter.application.Message;
import com.inCounter.shared.config.Configuration;
import com.inCounter.shared.config.ConfigurationManager;
import communication.Communication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Run {

    private final static Logger LOGGER = LoggerFactory.getLogger(Run.class);

    public static void main(String[] args) {
        ConfigurationManager.getInstance().loadConfigurationFile("shared/src/main/resources/config.json");
        Configuration conf = ConfigurationManager.getInstance().getCurrentConfiguration();

        Communication communication = new Communication(conf);
        communication.sendMessage("gay", "2");

        Communication communication2 = new Communication(conf);
        communication2.sendMessage("gay", "2");

        Communication communication3 = new Communication(conf);
        communication3.sendMessage("gay", "2");

        Communication communication4 = new Communication(conf);
        communication4.sendMessage("gay", "2");

        Communication communication5 = new Communication(conf);
        communication5.sendMessage(conf.getNewSession(), "0");

        Communication communication6 = new Communication(conf);
        communication6.sendMessage("gay", "2");


        LOGGER.info("Run running");
    }

}
