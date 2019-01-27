package com.zhishang.thread;

import com.zhishang.WebPicDownloader;

public class WebPicDownloadRunnable implements Runnable{
    private String url;
    private String name;

    public WebPicDownloadRunnable(String url, String name){
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
         WebPicDownloadRunnable thread1 = new WebPicDownloadRunnable("http://www.6gdown.com/uploads/allimg/1703/ImgNCgycwJt76bdz3RDJoG9.jpg", "pic1");
         WebPicDownloadRunnable thread2 = new WebPicDownloadRunnable("http://www.6gdown.com/uploads/allimg/1703/ImgjR2EYucPAkl8J080p4k4.jpg", "pic2");
         WebPicDownloadRunnable thread3 = new WebPicDownloadRunnable("http://www.6gdown.com/uploads/allimg/1703/ImgaSvlUjhNBoHWfMmNanwi.jpg", "pic3");

        new Thread(thread1).start();
        new Thread(thread2).start();
        new Thread(thread3).start();
    }
}
