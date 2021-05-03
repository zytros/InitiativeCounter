package communication;

import java.util.LinkedList;
import java.util.Queue;

public class SharedQueue {
    public Queue<Caller> q;

    public SharedQueue (){
        q = new LinkedList<Caller>();
    }

    public synchronized Caller poll(){
        return q.poll();
    }
    public synchronized boolean isEmpty(){
        return q.isEmpty();
    }
    public synchronized void add(Caller c){
        q.add(c);
    }
}
