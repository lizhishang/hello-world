package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 封装响应信息
 * 1、内容可以动态增加
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 20:06 2019-01-28
 */
public class ServerV4 {
    private ServerSocket serverSocket;

    public static void main(String[] args) {
        ServerV4 server = new ServerV4();
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
            RequestV2 requestV2 = new RequestV2(client);

            Response response = new Response(client);
            response.println("<html>");
            response.println("<head>");
            response.println("</head>");
            response.println("<body>");
            response.println("<h1>");
            response.println("Here is respond." + requestV2.getParameterValues("a")[1]);
            response.println("</h1>");
            response.println("</body>");
            response.println("</html>");

            response.pushToBrowse(200);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
