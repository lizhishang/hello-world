package com.zhishang.gof.composite.sample;

import java.util.ArrayList;
import java.util.List;

//抽象构建
public interface AbstractFile {
    void killVirus();
}

class ImageFile implements AbstractFile {
    private String name;

    public ImageFile(String name) {
        this.name = name;
    }

    @Override
    public void killVirus() {
        System.out.println("查杀" + name + "图像文件");
    }
}

class VideoFile implements AbstractFile {
    private String name;

    public VideoFile(String name) {
        this.name = name;
    }

    @Override
    public void killVirus() {
        System.out.println("查杀" + name + "录音文件");
    }
}

class TextFile implements AbstractFile {
    private String name;

    public TextFile(String name) {
        this.name = name;
    }

    @Override
    public void killVirus() {
        System.out.println("查杀" + name + "文本文件");
    }
}

class Folder implements AbstractFile {
    private String name;
    //定义容器，用来放本容器构建下的字节点
    private List<AbstractFile> files = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void add(AbstractFile file) {
        files.add(file);
    }

    public void remove(AbstractFile file) {
        files.remove(file);
    }

    public AbstractFile getChild(int index) {
        return files.get(index);
    }

    @Override
    public void killVirus() {
        System.out.println("进入查杀" + name + "文件夹. 文件数量:" + files.size());
        for (AbstractFile file : files) {
            file.killVirus();
        }
    }
}