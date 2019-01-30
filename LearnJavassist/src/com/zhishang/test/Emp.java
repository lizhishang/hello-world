package com.zhishang.test;

/**
 * TODO
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 12:51 2019-01-30
 */
public class Emp {
    private int empno;
    private String ename;

    public Emp(int empno, String ename) {
        this.empno = empno;
        this.ename = ename;
    }

    public Emp() {
    }

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }
}
