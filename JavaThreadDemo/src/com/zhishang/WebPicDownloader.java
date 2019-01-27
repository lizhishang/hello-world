package com.zhishang;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class WebPicDownloader {
    public void download(String url, String filename) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(filename));
        } catch (MalformedURLException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
