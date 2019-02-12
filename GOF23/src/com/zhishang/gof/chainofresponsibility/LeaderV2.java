package com.zhishang.gof.chainofresponsibility;

/**
 * Leader of Grade 2
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 10:41 2019-02-04
 */
public class LeaderV2 extends Leader {

    public LeaderV2(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveRequest request) {
        if (request.getLeaveDays() > 3 && request.getLeaveDays() < 10) {
            System.out.println(request);
            System.out.println("审批人：" + this.name);
        } else {
            if (this.nextLeader != null) {
                this.nextLeader.handleRequest(request);
            }
        }
    }
}
