package com.initiativeCounter.webserverMauven;

import com.initiativeCounter.webserverMauven.config.Configuration;
import com.initiativeCounter.webserverMauven.config.ConfigurationManager;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 *
 * Driver Class for the server
 *
 */
public class Server {
    public static void main(String args[]){

        System.out.println("Server started...\n");

        ConfigurationManager.getInstance().loadConfigurationFile("webServerMauven/src/main/resources/http.json");
        Configuration conf = ConfigurationManager.getInstance().getCurrentConfiguration();

        System.out.printf("Using Port: %d\nUsing WebRoot: %s\n", conf.getPort(), conf.getWebroot());

        try {
            ServerSocket serverSocket = new ServerSocket(conf.getPort());
            Socket socket = serverSocket.accept();

            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            // TODO read
            //dontcare

            // TODO writing

            String html = "<html><head><title>Simple Java HTTP Server</title></head><body><h1>This page was served using my Server</h1></body></html>";

            final String CRLF = "\n\r";//13, 10

            String response =
                    "HTTP/1.1 200 OK" + CRLF + //Status Line : HTTP_VERSION RESPONCE_CODE RESPONSE_MESSAGE
                    "Content-Length" + html.getBytes().length + CRLF + //HEADER
                            CRLF +
                            html +
                            CRLF + CRLF ;

            outputStream.write(response.getBytes());

            inputStream.close();
            outputStream.close();
            socket.close();
            serverSocket.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
