package com.inCounter.core;

import com.inCounter.application.InputManager;
import com.inCounter.config.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerListenerThread extends Thread{
    private ServerSocket serverSocket;
    private InputManager inputManager;
    private Configuration configuration;
    private final static Logger LOGGER = LoggerFactory.getLogger(ServerListenerThread.class);
    private boolean run;

    public ServerListenerThread(InputManager inputManager, Configuration configuration) throws IOException {
        this.serverSocket = new ServerSocket(configuration.getPort());
        this.inputManager = inputManager;
        this.configuration = configuration;
        this.run = true;
    }

    @Override
    public void run() {
        LOGGER.info("Server running, listening on port " + configuration.getPort() + " at host " + configuration.getHost());
        try {
            while(serverSocket.isBound() && !serverSocket.isClosed() && run) {
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
        LOGGER.info("Server shutdown");
    }

    public void serverShutdown(String pw){
        if (pw.equals(configuration.getPassword())){
            run = false;
            LOGGER.info("Shutting down server");
        }

    }

}
