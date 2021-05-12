package Test;


import GUI.test;
import character.Character;
import com.inCounter.shared.config.Configuration;
import com.inCounter.shared.config.ConfigurationManager;
import communication.Caller;
import communication.Communication;
import communication.SharedQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;


public class Test2 {

    private final static Logger LOGGER = LoggerFactory.getLogger(Test2.class);

    public static void main(String[] args) throws InterruptedException {

        ConfigurationManager.getInstance().loadConfigurationFile("shared/src/main/resources/config.json");
        Configuration conf = ConfigurationManager.getInstance().getCurrentConfiguration();

        HashMap<Integer,Character> C = new HashMap<>();
        SharedQueue show = new SharedQueue();
        show.q.add(new Caller("1","addChar",null));
        Communication com = new Communication(show, conf);
        Thread t = new Thread(com);
        t.start();
        test gui = new test(C);
        Thread g = new Thread(gui);
        g.start();




        for(int i = 0; i < 100;) {

            if (!show.isEmpty()) {
                i++;
                LOGGER.info("working");
                Caller order = show.poll();
                LOGGER.info(order.getId() + ", " + order.getMethod() + ", " + order.getValue());

                if (order.getMethod().equals("addChar")){
                    C.put(Integer.parseInt(order.getId()),new Character(Integer.parseInt(order.getId())));
                }
                else{
                    C.get(Integer.parseInt(order.getId())).callmethod(order.getMethod(), order.getValue());
                }


            }
        }
    }
}
