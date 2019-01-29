package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * 接收信息并返回响应信息
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 20:06 2019-01-28
 */
public class ServerV1 {
    private ServerSocket serverSocket;

    public static void main(String[] args) {
        ServerV1 serverV1 = new ServerV1();
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

            StringBuilder content = new StringBuilder();
            content.append("<html>");
            content.append("<head>");
            content.append("</head>");
            content.append("<body>");
            content.append("<h1>");
            content.append("Here is respond.");
            content.append("</h1>");
            content.append("</body>");
            content.append("</html>");
            int size = content.toString().getBytes().length;

            StringBuilder respondInfo = new StringBuilder();
            String blank = " ";
            String CRLF = "\r\n";

            // 响应行
            respondInfo.append("HTTP/1.1").append(blank)
                    .append(200).append(blank)
                    .append("ok").append(CRLF);
            // 响应头
            respondInfo.append("Date:").append(new Date()).append(CRLF)
                    .append("Server:").append("test server/0.0.1;charset=UTF-8").append(CRLF)
                    .append("Content-type:text/html").append(CRLF)
                    .append("Content-length:" + size).append(CRLF).append(CRLF);
            //正文
            respondInfo.append(content.toString());
            //写到客户端
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            writer.write(respondInfo.toString());
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
