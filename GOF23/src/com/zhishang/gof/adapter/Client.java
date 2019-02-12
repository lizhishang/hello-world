package com.zhishang.gof.adapter;

/**
 * TODO
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 14:49 2019-02-02
 */
public class Client {
    public void test1(Target target) {
        target.handleReq();
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.test1(new AdapterV2(new Adaptee()));
    }
}
