package communication;

import com.inCounter.shared.config.Configuration;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Communication extends Thread{

    private boolean run;
    private String address;
    private int port;
    public SharedQueue share;
    Configuration configuration;


    public Communication(SharedQueue share, Configuration configuration){
        this.address = configuration.getHost();
        this.port = configuration.getPort();
        run = true;
        this.share = share;
        this.configuration = configuration;
    }

    @Override
    public void run() {

        String call = configuration.getDisplay();
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
                response = inputStream.readUTF();
                String[] responsearr = response.split("  ");

                if(!responsearr[0].equals(configuration.getNoData())) {
                    for (int i = 0; i < responsearr.length; i ++) {
                        String[] action = responsearr[i].split(" ");
                        if(action.length > 3){
                            for(int j = 3; j < action.length; j++){
                                action[2] = action[2] + " " + action[j];
                            }
                        }
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
