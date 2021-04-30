package server;


import java.io.*;
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

/*
            String html = "<html><head><title>Simple Java HTTP Server</title></head><body><h1>This page was served using my Server</h1></body></html>";

            final String CRLF = "\n\r";//13, 10

            String response =
                    "HTTP/1.1 200 OK" + CRLF + //Status Line : HTTP_VERSION RESPONCE_CODE RESPONSE_MESSAGE
                            "Content-Length" + html.getBytes().length + CRLF + //HEADER
                            CRLF +
                            html +
                            CRLF + CRLF;

            outputStream.write(response.getBytes());
*/
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
