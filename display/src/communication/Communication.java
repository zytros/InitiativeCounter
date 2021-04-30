package communication;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;

public class Communication extends Thread{

    private boolean run;
    private String address;
    private int port;

    public Communication(String address, int port){
        this.address = address;
        this.port = port;
        run = true;
    }


    @Override
    public void run() {

        String call = "display";
        Socket client = null;
        String response = "";
        DataOutputStream outputStream = null;
        DataInputStream inputStream = null;
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
                response = inputStream.readUTF();

                /**
                 * response here available
                 * TODO: use response
                 */

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
