package sample.download;

import sample.download.file.DownloadFileThread;
import sample.download.progress.DownloadProgressTracker;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SaveFileFromURL implements Runnable {


    private final String fileExtension;
    private final URL url;
    private String filename;
    private String saveFilePath;
    private FileOutputStream fileOutputStream = null;
    private ReadableByteChannel readableByteChannel = null;

    public SaveFileFromURL(URL url, String fileExtension) {
        this.url = url;
        this.fileExtension = fileExtension;
    }

    @Override
    public void run() {

        filename = "test." + fileExtension;

        saveFilePath = "C:/Users/User/Downloads" + File.separator + filename;

        try {
            readableByteChannel = Channels.newChannel(url.openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            fileOutputStream = new FileOutputStream(saveFilePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        FileChannel fileChannel = fileOutputStream.getChannel();

        DownloadFileThread download = new DownloadFileThread(fileChannel, readableByteChannel);

        DownloadProgressTracker progress = new DownloadProgressTracker(fileChannel, readableByteChannel);


        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.execute(progress);
        executorService.execute(download);

        executorService.shutdown();
    };
}
