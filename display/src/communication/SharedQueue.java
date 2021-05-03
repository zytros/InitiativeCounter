package communication;

import java.util.LinkedList;
import java.util.Queue;

public class SharedQueue {
    public Queue<Caller> q;

    public SharedQueue (){
        q = new LinkedList<Caller>();
    }
}
