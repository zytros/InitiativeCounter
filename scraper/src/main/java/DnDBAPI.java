import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DnDBAPI {
    String charURL = "https://character-service.dndbeyond.com/character/v5/character/";

    void getData(ArrayList<WebData> characters){
        List<Thread> ts = new LinkedList();
        for (WebData c : characters){
            APIThread AT = new APIThread(c);
            Thread t = new Thread(AT);
            t.start();
            ts.add(t);
        }for(Thread t : ts){
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
