package com.zhishang.thread;

import com.zhishang.WebPicDownloader;

import java.util.concurrent.*;

public class WebPicDownloadCallable implements Callable<Boolean> {
    private String url;
    private String name;

    public WebPicDownloadCallable(String url, String name){
        this.url = url;
        this.name = name;
    }

    @Override
    public Boolean call() {
        WebPicDownloader downloader = new WebPicDownloader();
        downloader.download(url, name);
        System.out.println(name + " finished");
        return true;
    }

    public static void main(String[] args) {
         WebPicDownloadCallable thread1 = new WebPicDownloadCallable("http://www.6gdown.com/uploads/allimg/1703/ImgNCgycwJt76bdz3RDJoG9.jpg", "pic1");
         WebPicDownloadCallable thread2 = new WebPicDownloadCallable("http://www.6gdown.com/uploads/allimg/1703/ImgjR2EYucPAkl8J080p4k4.jpg", "pic2");
         WebPicDownloadCallable thread3 = new WebPicDownloadCallable("http://www.6gdown.com/uploads/allimg/1703/ImgaSvlUjhNBoHWfMmNanwi.jpg", "pic3");

        ExecutorService service = Executors.newFixedThreadPool(3);
        Future<Boolean> future1 = service.submit(thread1);
        Future<Boolean> future2 = service.submit(thread2);
        Future<Boolean> future3 = service.submit(thread3);
        try {
            boolean r1 = future1.get();
            boolean r2 = future2.get();
            boolean r3 = future3.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
         service.shutdown();
    }
}
