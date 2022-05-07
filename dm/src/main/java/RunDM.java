import com.inCounter.shared.config.Configuration;
import communication.Communication;
import gui.dmScreen;
import util.CharUtil;

import javax.swing.*;

public class RunDM {
    static Configuration configuration = new Configuration();
    static Communication communication = new Communication(configuration);
    static CharUtil charUtil = new CharUtil(configuration, communication);
    static gui.dmScreen gui = new dmScreen(charUtil);

    public static void main(String[] args){
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch(Exception ignored){}
        JFrame frame = new JFrame("App");
        frame.setContentPane(gui.dude);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


}
