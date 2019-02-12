package com.zhishang.gof.chainofresponsibility;

/**
 * TODO
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 10:45 2019-02-04
 */
public class Client {
    public static void main(String[] args) {
        LeaveRequest request = new LeaveRequest("Li", 15, "I have a sick.");
        Leader leader1 = new LeaderV1("李家人");
        Leader leader2 = new LeaderV2("张家人");
        Leader leader3 = new LeaderV3("赵家人");
        leader1.setNextLeader(leader2);
        leader2.setNextLeader(leader3);

        leader1.handleRequest(request);
    }
}
