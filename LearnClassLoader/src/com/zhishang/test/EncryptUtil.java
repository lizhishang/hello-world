package com.zhishang.test;

import java.io.*;

/**
 * encrypt class
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 20:34 2019-01-30
 */
public class EncryptUtil {

    public static void main(String[] args) {
        encrypt("/Users/zhishangli/Desktop/Test.class",
                "/Users/zhishangli/Desktop/temp/Test.class");
    }

    public static void encrypt(String src, String dest) {
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
           in = new FileInputStream(src);
           out = new FileOutputStream(dest);
           int temp = -1;
           while((temp = in.read()) != -1) {
                //取反
                out.write(temp^0xff);
           }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
                try {
                    if (in != null) {
                        in.close();
                    }
                    if (out != null) {
                        out.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
}
