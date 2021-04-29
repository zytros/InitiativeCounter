package com.initiativeCounter.webserverMauven.core;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;

public class HttpConnectionWorkerThread extends Thread{
    private Socket socket;
    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);


    public HttpConnectionWorkerThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();


            // TODO read
            //dontcare


            String html = "<html><head><title>Simple Java HTTP Server</title></head><body><h1>This page was served using my Server</h1></body></html>";

            final String CRLF = "\n\r";//13, 10

            String response =
                    "HTTP/1.1 200 OK" + CRLF + //Status Line : HTTP_VERSION RESPONCE_CODE RESPONSE_MESSAGE
                            "Content-Length" + html.getBytes().length + CRLF + //HEADER
                            CRLF +
                            html +
                            CRLF + CRLF;

            outputStream.write(response.getBytes());



            LOGGER.info(" *Connection Processing Finished");

        } catch (IOException e) {
            LOGGER.warning("Problem with communication");
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