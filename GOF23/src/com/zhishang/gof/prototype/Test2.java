package com.zhishang.gof.prototype;

import java.io.*;
import java.util.Date;

/**
 * 用序列化和反序列化实现深复制
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 13:52 2019-02-02
 */
public class Test2 {
    public static void main(String[] args) throws Exception {
        Date data = new Date(1234565L);
        SheepV1 s1 = new SheepV1("tony", data);
        System.out.println(s1);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream outs = new ObjectOutputStream(out);
        outs.writeObject(s1);
        byte[] bytes = out.toByteArray();

        data.setTime(56789876L);
        System.out.println("s1.birthday" + s1.getBirthday());

        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        ObjectInputStream ins = new ObjectInputStream(in);
        SheepV1 s2 = (SheepV1)ins.readObject();
        System.out.println(s2);
    }
}
