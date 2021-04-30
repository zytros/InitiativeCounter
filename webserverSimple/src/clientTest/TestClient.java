package clientTest;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;

public class TestClient {
    public static void main(String args[]){
        System.out.println("Client: Client running");
        String call = "sending request";
        try {
            Socket client = new Socket("localhost", 8080);
            DataOutputStream outputStream = new DataOutputStream(client.getOutputStream());
            outputStream.writeUTF(call);

            DataInputStream inputStream = new DataInputStream(client.getInputStream());
            System.out.println("Client: " + inputStream.readUTF());

            client.close();

            System.out.println("Client: Client shutdown");
        } catch (ConnectException e){
            System.out.println("no connection possible, try again");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
