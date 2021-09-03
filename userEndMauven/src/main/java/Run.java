
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
        communication.sendMessage("create", "2");



        LOGGER.info("Run running");
    }

}
