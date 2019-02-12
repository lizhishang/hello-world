package com.zhishang.gof.chainofresponsibility;

/**
 * Leader of Grade 3
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 10:41 2019-02-04
 */
public class LeaderV3 extends Leader {

    public LeaderV3(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveRequest request) {
        if (request.getLeaveDays() >= 10 && request.getLeaveDays() <= 15) {
            System.out.println(request);
            System.out.println("审批人：" + this.name);
        } else {
            System.out.println("你想辞职吗");
        }
    }
}
