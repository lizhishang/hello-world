package server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * 封装响应信息
 * 1、内容可以动态增加
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 20:06 2019-01-28
 */
public class ServerV2 {
    private ServerSocket serverSocket;

    public static void main(String[] args) {
        ServerV2 serverV1 = new ServerV2();
        serverV1.start();
        serverV1.receive();
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
            System.out.println("a socket connected");
            InputStream is = client.getInputStream();
            byte[] data = new byte[1024 * 1024 * 10];
            int len = is.read(data);
            String str = new String(data, 0, len);
            System.out.println(str);

            Response response = new Response(client);
            response.println("<html>");
            response.println("<head>");
            response.println("</head>");
            response.println("<body>");
            response.println("<h1>");
            response.println("Here is respond.");
            response.println("</h1>");
            response.println("</body>");
            response.println("</html>");

            response.pushToBrowse(200);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
