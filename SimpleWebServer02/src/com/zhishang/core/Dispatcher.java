package com.zhishang.core;

import com.zhishang.servlet.ErrorServlet;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * 分发器
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 15:09 2019-01-29
 */
public class Dispatcher implements Runnable {
    private Socket client;
    private Request request;
    private Response response;

    public Dispatcher(Socket client) {
        this.client = client;
        //获得请求协议
        try {
            request = new Request(client);
            response = new Response(client);
        } catch (IOException e) {
            e.printStackTrace();
            this.release();
        }
    }

    @Override
    public void run() {
        try {
            if (request.getUrl() == null || request.getUrl().equals("")) {
                InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("index.html");
                response.print(new String(is.readAllBytes()));
                response.pushToBrowse(200);
                is.close();
            }
            //获得响应协议
            Servlet servlet = WebApp.getServletFromUrl(request.getUrl());

            if (!(servlet instanceof ErrorServlet)) {
                servlet.service(request, response);
                response.pushToBrowse(200);
            } else {
                InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("error.html");
                response.print(new String(is.readAllBytes()));
                response.pushToBrowse(404);
                is.close();
            }
            release();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void release() {
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
