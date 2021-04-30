package com.inCounter.core;

import com.inCounter.application.InputManager;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerListenerThread extends Thread{
    private int port;
    private ServerSocket serverSocket;
    private InputManager inputManager;

    public ServerListenerThread(int port, InputManager inputManager) throws IOException {
        this.port = port;
        this.serverSocket = new ServerSocket(this.port);
        this.inputManager = inputManager;
    }

    @Override
    public void run() {
        try {
            while(serverSocket.isBound() && !serverSocket.isClosed()) {
                Socket socket = this.serverSocket.accept();


                ConnectionWorkerThread workerThread = new ConnectionWorkerThread(socket, inputManager);
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
