package com.zhishang.test;

import java.io.*;

/**
 * 自定义文件系统加载器
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 16:27 2019-01-30
 */
public class FileSystemClassLoader extends ClassLoader {
    private String rootDir;

    public FileSystemClassLoader(String rootDir) {
        this.rootDir = rootDir;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class<?> c = findLoadedClass(name);
        //应该要先查询有没有加载这个类。如果已经加载，则直接返回加载好的类。如果没有，则加载新的类。
        if (c != null) {
            return c;
        } else {
            //委派给父类加载
            ClassLoader parent = this.getParent();
            try {
                c = parent.loadClass(name);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (c != null) {
                return c;
            } else {
                byte[] classData = getClassData(name);
                if (classData == null) {
                    throw new ClassNotFoundException();
                } else {
                    c = defineClass(name, classData, 0, classData.length);
                }
            }
        }
        return c;
    }

    /**
     *
     * @param name
     * @return class文件转换成字节数组
     */
    private byte[] getClassData(String name) {
        String path = rootDir + "/" + name.replace(".", "/") + ".class";
        InputStream in = null;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            in = new FileInputStream(path);
            byte[] buffer = new byte[1024];
            int temp = 0;
            while ((temp = in.read(buffer)) != -1) {
                out.write(buffer, 0, temp);
            }
            return out.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
