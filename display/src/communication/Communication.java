package communication;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Queue;

public class Communication extends Thread{

    private boolean run;
    private String address;
    private int port;
    public SharedQueue share;


    public Communication(String address, int port, SharedQueue share){
        this.address = address;
        this.port = port;
        run = true;
        this.share = share;
    }

    @Override
    public void run() {

        String call = "display";
        Socket client = null;
        String response = "";
        DataOutputStream outputStream = null;
        DataInputStream inputStream = null;
        Queue<String> queue = new LinkedList<>();
        try{
            client = new Socket(address, port);
            outputStream = new DataOutputStream(client.getOutputStream());
            inputStream = new DataInputStream(client.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }


        while(run){
            try {
                outputStream.writeUTF(call);
                String[] responsearr = inputStream.readUTF().split(" ");
                for(int i= 0 ; i < responsearr.length; i += 3 )
                share.q.add(new Caller(responsearr[i],responsearr[i+1], responsearr[i+2]));


            } catch (IOException e) {
                e.printStackTrace();
            }


            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
