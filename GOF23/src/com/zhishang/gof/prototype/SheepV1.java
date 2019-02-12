package com.zhishang.gof.prototype;

import java.io.Serializable;
import java.util.Date;

/**
 * V1: 浅复制
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 12:26 2019-02-02
 */
public class SheepV1 implements Serializable, Cloneable {
    private String sname;
    private Date birthday;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public SheepV1() {
    }

    public SheepV1(String sname, Date birthday) {
        this.sname = sname;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "SheepV1{" +
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
