package com.zhishang.gof.chainofresponsibility;

/**
 * Leader of Grade 1
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 10:41 2019-02-04
 */
public class LeaderV1 extends Leader {

    public LeaderV1(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveRequest request) {
        if (request.getLeaveDays() <= 3) {
            System.out.println(request);
            System.out.println("审批人：" + this.name);
        } else {
            if (this.nextLeader != null) {
                this.nextLeader.handleRequest(request);
            }
        }
    }
}
