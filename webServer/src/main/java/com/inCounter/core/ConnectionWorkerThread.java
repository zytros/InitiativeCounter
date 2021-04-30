package com.inCounter.core;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ConnectionWorkerThread extends Thread{
    private Socket socket;


    public ConnectionWorkerThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println("Server: New Connection");
        InputStream inputStream = null;
        DataOutputStream outputStream = null;
        try {
            inputStream = socket.getInputStream();
            outputStream = new DataOutputStream(socket.getOutputStream());





            // TODO read

            DataInputStream input = new DataInputStream(inputStream);
            System.out.println("Server: " + input.readUTF());


            String response = "recieved message";
            outputStream.writeUTF(response);


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {}
            }if(outputStream != null){
                try {
                    outputStream.close();
                } catch (IOException e) {}
            }if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {}
            }
        }
    }
}
