package com.zhishang.bean;

/**
 * TODO
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 20:36 2019-01-29
 */
public class User {
    private String uname;
    private String pwd;
    private int age;

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPwd() {
        return pwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "uname='" + uname + '\'' +
                ", pwd='" + pwd + '\'' +
                ", age=" + age +
                '}';
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User(String uname, String pwd, int age) {
        this.uname = uname;
        this.pwd = pwd;
        this.age = age;
    }

    public User() {
    }
}
