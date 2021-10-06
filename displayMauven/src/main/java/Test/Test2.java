package Test;


import GUI.Frame;
import character.Character;
import com.inCounter.shared.config.Configuration;
import com.inCounter.shared.config.ConfigurationManager;
import communication.Caller;
import communication.Communication;
import communication.SharedQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;


public class Test2 {

    private final static Logger LOGGER = LoggerFactory.getLogger(Test2.class);

    public static void main(String[] args) throws InterruptedException {

        ConfigurationManager.getInstance().loadConfigurationFile("shared/src/main/resources/config.json");
        Configuration conf = ConfigurationManager.getInstance().getCurrentConfiguration();

        Map<Integer,Character> C = new HashMap<>();
        SharedQueue show = new SharedQueue();



        show.q.add(new Caller("1","addChar",null));
        show.q.add(new Caller("2","addChar",null));
        show.q.add(new Caller("3","addChar",null));
        show.q.add(new Caller("1", "setInitiative", "22.0"));
        show.q.add(new Caller("2", "setInitiative", "18.0"));
        show.q.add(new Caller("3", "setInitiative", "15.0"));
        Communication com = new Communication(show, conf);
        Thread t = new Thread(com);
        t.start();
        Frame gui = new Frame(C);
        Thread g = new Thread(gui);
        g.start();


        //TODO: get char info

        for(int i = 0; i < 100;) {

            if (!show.isEmpty()) {
                i++;
                LOGGER.info("working");
                Caller order = show.poll();
                LOGGER.info(order.getId() + ", " + order.getMethod() + ", " + order.getValue());

                if (order.getMethod().equals("addChar")){
                    C.put(Integer.parseInt(order.getId()),new Character(Integer.parseInt(order.getId())));
                }else if(order.getId().equals("0")){
                    switch(order.getMethod()){
                        case "startFight":
                            gui.charContainer.startFight();
                            break;
                        case "endFight":
                            gui.charContainer.endFight();
                            break;
                        case "next":
                            gui.charContainer.next();
                    }

                }else{
                    C.get(Integer.parseInt(order.getId())).callmethod(order.getMethod(), order.getValue());
                }


            }
        }
    }
}
