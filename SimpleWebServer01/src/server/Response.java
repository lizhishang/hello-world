package server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Date;

/**
 * TODO
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 21:36 2019-01-28
 */
public class Response {
    private final String BLANK = " ";
    private final String CRLF = "\r\n";

    private BufferedWriter writer;
    //存储响应头信息
    private StringBuilder head;
    //存储正文
    private StringBuilder content;
    //存储字节长度
    private int len;

    private Response() {
        head = new StringBuilder();
        content = new StringBuilder();
        len = 0;
    }

    public Response(Socket client) {
        this();
        try {
            this.writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void pushToBrowse(int code) {
        try {
            if (null == head) {
                code = 505;
            }
            createHeadInfo(code);
            writer.write(head.append(content).toString());
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Response print(String info) {
        content.append(info);
        len += info.getBytes().length;
        return this;
    }

    public Response println(String info) {
        content.append(info).append(CRLF);
        len += info.getBytes().length + CRLF.getBytes().length;
        return this;
    }

    private void createHeadInfo(int code) {
        // 响应行
        head.append("HTTP/1.1").append(BLANK)
                .append(code).append(BLANK);
        switch (code) {
            case 200:
                head.append("success").append(CRLF);
                break;
            case 404:
                head.append("not found").append(CRLF);
                break;
            case 505:
                head.append("SERVER ERROR").append(CRLF);
                break;
        }
        // 响应头
        head.append("Date:").append(new Date()).append(CRLF);
        head.append("Server:").append("test server/0.0.1;charset=UTF-8").append(CRLF)
            .append("Content-type:text/html").append(CRLF)
            .append("Content-length:" + len).append(CRLF).append(CRLF);
    }
}
