package Test;

import communication.Caller;
import communication.Communication;
import communication.SharedQueue;

import java.util.concurrent.TimeUnit;

public class Test1 {
    public static void main(String[] args) throws InterruptedException {
        SharedQueue show = new SharedQueue();
        show.q.add(new Caller("1","startprog",null));
        Communication test = new Communication("srab.duckdns.org", 25565,show);
        Thread t = new Thread(test);
        t.start();



        for(int i = 0; i < 100;) {

            if (!show.isEmpty()) {
                i++;
                System.out.println("working");
                Caller out = show.poll();
                System.out.println(out.getId() + ", " + out.getMethod() + ", " + out.getValue());
            }
        }
    }
}
