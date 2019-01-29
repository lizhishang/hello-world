package com.zhishang.core;

/**
 * TODO
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 14:02 2019-01-29
 */
public interface Servlet {
    void service(Request request, Response response);
//    void doGet(com.zhishang.core.Request request, com.zhishang.core.Response response);
//    void doPost(com.zhishang.core.Request request, com.zhishang.core.Response response);
}
