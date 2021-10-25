import com.inCounter.shared.config.Configuration;
import communication.Communication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class Main {
    Configuration configuration = new Configuration();
    Communication communication = new Communication(configuration);
    int npcid = 100;
    ArrayList<Character> npcList = new ArrayList<>();

    public static void main(String[] args){

    }

    //TODO: functions startFight, endFight, next, addMonster, getChar
    public void startFight(){
        communication.sendMessage(configuration.getStartFight(), "0");
        //TODO: add gui
    }

    public void endFight(){
        communication.sendMessage(configuration.getEndFight(), "0");
        //TODO: add gui

    }

    public void next(){
        communication.sendMessage(configuration.getNext(), "0");
    }

    public void addNPC(){
        Character c = new Character(npcid++, "Unknown NPC", 1.0);
        communication.sendMessage(c.getId(), configuration.getAddNPC(), "0");                                     // add new npc
        communication.sendMessage(c.getId(), configuration.getSetName(), c.getName());                                  // set name
        communication.sendMessage(c.getId(), configuration.getSetInitiative(), String.valueOf(c.getInitiative()));      // set name

    }


    private String getChar(int id){
        String target = "";
        communication.sendMessage(configuration.getGetCharInfo(), String.valueOf(id), target);
        return target;
        //TODO;
    }

}
