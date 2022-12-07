
import com.inCounter.shared.config.Configuration;
import com.inCounter.shared.config.ConfigurationManager;
import communication.Communication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class Run {

    private final static Logger LOGGER = LoggerFactory.getLogger(Run.class);

    public static void main(String[] args) {
        ConfigurationManager.getInstance().loadConfigurationFile("shared/src/main/resources/config.json");
        Configuration conf = ConfigurationManager.getInstance().getCurrentConfiguration();

        Communication communication = new Communication(conf);
        Scanner sc = new Scanner(System.in);
        boolean run = true;
        boolean cont = true;
        while(run){
            System.out.println("Current ID: " + communication.id);
            cont = true;
            String in1 = sc.next();
            String in2 = sc.next();
            if(in1.equals("terminate")){
                run = false;
                break;
            }else if(in1.equals("id")){
                communication.id = Integer.parseInt(in2);
                cont = false;
            }
            if(cont) {
                communication.sendMessage(in1, in2);
            }
        }

        /*
        communication.sendMessage("setName", "Luca");
        communication.sendMessage("changeHP", "10");
        communication.sendMessage("setInitiative", "15");

        /*
        Communication communication2 = new Communication(conf);
        communication2.sendMessage("gay", "2");

        Communication communication3 = new Communication(conf);
        communication3.sendMessage("gay", "2");

        Communication communication4 = new Communication(conf);
        communication4.sendMessage("gay", "2");

        Communication communication5 = new Communication(conf);
        communication5.sendMessage(conf.getNewSession(), "0");

        Communication communication6 = new Communication(conf);
        communication6.sendMessage("gay", "2");*/


    }



}
