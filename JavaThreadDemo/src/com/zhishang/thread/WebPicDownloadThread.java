package com.zhishang.thread;

import com.zhishang.WebPicDownloader;

public class WebPicDownloadThread extends Thread {
    private String url;
    private String name;

    public WebPicDownloadThread(String url, String name){
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        WebPicDownloader downloader = new WebPicDownloader();
        downloader.download(url, name);
        System.out.println(name + " finished");
    }

    public static void main(String[] args) {
         WebPicDownloadThread thread1 = new WebPicDownloadThread("http://www.6gdown.com/uploads/allimg/1703/ImgNCgycwJt76bdz3RDJoG9.jpg", "pic1");
         WebPicDownloadThread thread2 = new WebPicDownloadThread("http://www.6gdown.com/uploads/allimg/1703/ImgjR2EYucPAkl8J080p4k4.jpg", "pic2");
         WebPicDownloadThread thread3 = new WebPicDownloadThread("http://www.6gdown.com/uploads/allimg/1703/ImgaSvlUjhNBoHWfMmNanwi.jpg", "pic3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
