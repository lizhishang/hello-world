package com.zhishang.gof.prototype;

import java.util.Date;

/**
 * V2: 深复制
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 12:26 2019-02-02
 */
public class SheepV2 implements Cloneable {
    private String sname;
    private Date birthday;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        SheepV2 sheep = (SheepV2) super.clone();
        sheep.birthday = (Date) this.birthday.clone();
        return sheep;
    }

    public SheepV2() {
    }

    public SheepV2(String sname, Date birthday) {
        this.sname = sname;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "SheepV2{" +
                "sname='" + sname + '\'' +
                ", birthday=" + birthday +
                '}';
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
