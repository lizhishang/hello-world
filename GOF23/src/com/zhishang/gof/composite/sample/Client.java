package com.zhishang.gof.composite.sample;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 17:41 2019-02-02
 */
public class Client {
    public static void main(String[] args) {
        AbstractFile f1;
        AbstractFile f2;
        AbstractFile f3;
        AbstractFile f4;
        f1 = new VideoFile("hero");
        f2 = new ImageFile("amuro");
        f3 = new TextFile("namie");

        f4 = new Folder("my love");
        ((Folder) f4).add(f1);
        ((Folder) f4).add(f2);
        ((Folder) f4).add(f3);

        AbstractFile f5 = new Folder("xixi");
        ((Folder) f5).add(f1);
        ((Folder) f5).add(f3);
        ((Folder) f4).add(f5);
        f4.killVirus();
    }
}
