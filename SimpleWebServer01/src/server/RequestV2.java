package server;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.*;

/**
 * 封装请求信息：获取method uri以及请求参数
 * V2:封装请求参数
 * @author zhishangli
 * @project_name hello-world
 * @time 22:04 2019-01-28
 */
public class RequestV2 {
    private Map<String, List<String>> parameterMap;
    private String requestInfo;
    private String method;
    private String queryStr;
    private String url;
    private final String CRLF = "\r\n";

    public RequestV2(InputStream is) {
        try {
            parameterMap = new HashMap<String, List<String>>();
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
    public RequestV2(Socket client) throws IOException {
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
        convertToMap();
    }

    private void convertToMap() {
        String[] keyValues = this.queryStr.split("&");
        for (String str : keyValues) {
            String[] kv = str.split("=");
            kv = Arrays.copyOf(kv, 2);
            String key = kv[0];
            String value = kv[1] == null ? null : decode(kv[1], "UTF-8");
            if (!parameterMap.containsKey(key)) {
                parameterMap.put(key, new ArrayList<String>());
            }
            parameterMap.get(key).add(value);
        }
    }

    public String[] getParameterValues(String key) {
        List<String> values = this.parameterMap.get(key);
        if (values != null && values.size() > 0) {
            return values.toArray(new String[0]);
        }
        return null;
    }

    //处理中文
    private String decode(String value, String charset) {
        try {
            return java.net.URLDecoder.decode(value, charset);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getParameterValue(String key) {
        String[] values = getParameterValues(key);
        return values == null ? null : values[0];
    }
}
