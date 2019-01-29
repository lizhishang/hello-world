package com.zhishang.core;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * Simple Web Server
 * V3:加入线程
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 20:06 2019-01-28
 */
public class ServerV3 {
    private ServerSocket serverSocket;
    private boolean isRunning;
    public static void main(String[] args) {
        ServerV3 server = new ServerV3();
        server.start();
        server.receive();
    }

    public void start() {
        try {
            serverSocket = new ServerSocket(12345);
            isRunning = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void shutdown() {
        isRunning = false;
        try {
            serverSocket.close();
            System.out.println("shutdown");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void receive() {
        try {
            //多线程
            while (isRunning) {
                new Thread(new Dispatcher(serverSocket.accept())).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
            shutdown();
        }
    }
}
