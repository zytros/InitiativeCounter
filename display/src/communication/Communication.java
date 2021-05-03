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



        while(run){
            DataOutputStream outputStream = null;
            DataInputStream inputStream = null;

            try{
                client = new Socket(address, port);
                outputStream = new DataOutputStream(client.getOutputStream());
                inputStream = new DataInputStream(client.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                outputStream.writeUTF(call);
                //while(inputStream.available()>0) {
                   // System.out.println(inputStream.readUTF());
                response = inputStream.readUTF();
                //System.out.println(response);
                String[] responsearr = response.split("  ");

                if(!responsearr[0].equals("noData")) {
                    for (int i = 0; i < responsearr.length; i ++) {
                        String[] action = responsearr[i].split(" ");
                        share.add(new Caller(action[0], action[1], action[2]));
                    }
                }


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
