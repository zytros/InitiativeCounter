import com.inCounter.shared.config.Configuration;
import communication.Communication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    Configuration configuration = new Configuration();
    Communication communication = new Communication(configuration);

    public static void main(String[] args){

    }

    //TODO: functions startFight, endFight, next, addMonster, getChar

    private void startFight(){
        communication.sendMessage(configuration.getStartFight(), "0");
        //TODO: add gui
    }

    private void endFight(){
        communication.sendMessage(configuration.getEndFight(), "0");
        //TODO: add gui

    }

    private void next(){
        communication.sendMessage(configuration.getNext(), "0");
    }

    private void getChar(int id){
        communication.sendMessage(configuration.getGetCharInfo(), String.valueOf(id));
        //TODO;
    }

}
