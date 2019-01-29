package com.zhishang.core;

import com.zhishang.servlet.LoginServlet;
import com.zhishang.servlet.RegisterServlet;

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
public class ServerV1 {
    private ServerSocket serverSocket;

    public static void main(String[] args) {
        ServerV1 server = new ServerV1();
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

            Servlet servlet = null;
            if(request.getUrl().equalsIgnoreCase("login")){
                servlet = new LoginServlet();
            } else if(request.getUrl().equalsIgnoreCase("register")){
                servlet = new RegisterServlet();
            } else {
//                404 or index
            }
            servlet.service(request, response);

            response.pushToBrowse(200);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
