package com.zhishang.gof.prototype;

import java.util.Date;

/**
 * Test clone (浅克隆 & 深克隆)
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 12:32 2019-02-02
 */
public class Test {
    public static void main(String[] args) throws Exception {
        Date data = new Date(1234565L);
        SheepV2 s1 = new SheepV2("tony", data);
        System.out.println(s1);
        System.out.println(s1.hashCode());

        SheepV2 s2 = (SheepV2) s1.clone();
        data.setTime(98765432L);
        System.out.println(s2);
        System.out.println(s2.hashCode());
    }
}
