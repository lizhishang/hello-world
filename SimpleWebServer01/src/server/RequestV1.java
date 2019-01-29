package server;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * 封装请求信息：获取method uri以及请求参数
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 22:04 2019-01-28
 */
public class RequestV1 {
    private String requestInfo;
    private String method;
    private String queryStr;
    private String url;
    private final String CRLF = "\r\n";

    public RequestV1(InputStream is) {
        try {
            byte[] data = new byte[1024 * 1024 * 10];
            int len = 0;
            len = is.read(data);
            requestInfo = new String(data, 0, len);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        parseRequestInfo();
    }
    public RequestV1(Socket client) throws IOException {
        this(client.getInputStream());
    }

    public void parseRequestInfo() {
        System.out.println(requestInfo);
        this.method = requestInfo.substring(0, requestInfo.indexOf("/")).trim().toLowerCase();
        this.url = requestInfo.substring(requestInfo.indexOf("/") + 1, requestInfo.indexOf("HTTP/")).trim();
        int query = this.url.indexOf("?");
        if (query > 0) {
            String[] strings = url.split("\\?");
            this.url = strings[0];
            this.queryStr = strings[1];
        }
        if(method.equalsIgnoreCase("post")) {
            String qStr = this.requestInfo.substring(this.requestInfo.lastIndexOf("\n") + 1);
            if (queryStr == null) {
                queryStr = qStr;
            } else {
                queryStr = queryStr + "&" + qStr;
            }
        }
        System.out.println(method + "-->" + url + "-" + queryStr);
    }
}
