import server.ServerListenerThread;

import java.io.IOException;

public class Server {

    public static void main(String args[]){
        System.out.println("Server starting...");

        int port = 8080;

        ServerListenerThread serverListenerThread = null;
        try {
            serverListenerThread = new ServerListenerThread(port);
            serverListenerThread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }


}
