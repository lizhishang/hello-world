package com.zhishang.core;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Simple Web Server
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 20:06 2019-01-28
 */
public class ServerV2 {
    private ServerSocket serverSocket;

    public static void main(String[] args) {
        ServerV2 server = new ServerV2();
        server.start();
        server.receive();
    }

    public void start() {
        try {
            serverSocket = new ServerSocket(12345);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void shutdown() {

    }

    public void receive() {
        try {
            Socket client = serverSocket.accept();
            //获得请求协议
            Request request = new Request(client);
            //获得响应协议
            Response response = new Response(client);

            Servlet servlet = WebApp.getServletFromUrl(request.getUrl());
            servlet.service(request, response);

            if (null != servlet) {
                response.pushToBrowse(200);
            } else {
                response.pushToBrowse(404);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
