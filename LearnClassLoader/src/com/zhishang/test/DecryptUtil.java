package com.zhishang.test;

import java.io.*;

/**
 * decrypt class
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 20:51 2019-01-30
 */
public class DecryptUtil extends ClassLoader {
    private String rootDir;

    public DecryptUtil(String rootDir) {
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

            int temp = -1;
            while((temp = in.read()) != -1) {
                out.write(temp^0xff);  //取反操作，相对于简单解密
            }

            return out.toByteArray();
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
