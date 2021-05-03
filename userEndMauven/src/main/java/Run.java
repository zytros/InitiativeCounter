import com.inCounter.Server;
import config.Configuration;
import config.ConfigurationManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Run {

    private final static Logger LOGGER = LoggerFactory.getLogger(Run.class);

    public static void main(String[] args) {
        ConfigurationManager.getInstance().loadConfigurationFile("userEndMauven/src/main/resources/config.json");
        Configuration conf = ConfigurationManager.getInstance().getCurrentConfiguration();

        LOGGER.info("Run running");
    }

}
