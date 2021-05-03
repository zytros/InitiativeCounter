package Test;

import communication.Caller;
import communication.Communication;
import communication.SharedQueue;

public class Test1 {
    public static void main(String[] args) {
        SharedQueue show = new SharedQueue();
        show.q.add(new Caller("1","startprog",null));
        Communication test = new Communication("srab.duckdns.org", 25565,show);
        test.start();
        while(true) {
            if (!show.q.isEmpty()) {
                Caller out = show.q.poll();
                System.out.println(out.getId() + ", " + out.getMethod() + ", " + out.getValue());
            }
        }
    }
}
