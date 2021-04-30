package com.inCounter.core;

import com.inCounter.application.InputManager;
import com.inCounter.config.Configuration;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerListenerThread extends Thread{
    private int port;
    private ServerSocket serverSocket;
    private InputManager inputManager;
    private Configuration configuration;

    public ServerListenerThread(int port, InputManager inputManager, Configuration configuration) throws IOException {
        this.port = port;
        this.serverSocket = new ServerSocket(this.port);
        this.inputManager = inputManager;
        this.configuration = configuration;
    }

    @Override
    public void run() {
        try {
            while(serverSocket.isBound() && !serverSocket.isClosed()) {
                Socket socket = this.serverSocket.accept();


                ConnectionWorkerThread workerThread = new ConnectionWorkerThread(socket, inputManager, configuration);
                workerThread.start();

            }


        } catch (IOException e) {
        } finally {
            if(serverSocket != null){
                try {
                    serverSocket.close();
                } catch (IOException e) {}
            }
        }
    }
}
