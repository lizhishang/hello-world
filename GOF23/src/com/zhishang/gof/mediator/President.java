package com.zhishang.gof.mediator;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 23:41 2019-02-10
 */
public class President implements Mediator {
    private Map<String, Department> map = new HashMap<>();

    @Override
    public void register(String dname, Department department) {
        map.put(dname, department);
    }

    @Override
    public void command(String dname) {
        map.get(dname).outAction();
    }
}
