package sample.download;

import sample.download.file.DownloadFileTask;
import sample.download.progress.DownloadProgressTracker;
import sample.gui.DownloadItemBar;

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

public class SaveFileFromURL{


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

    public void runDownload(DownloadItemBar bar) {

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

        DownloadProgressTracker progress = new DownloadProgressTracker(fileChannel, readableByteChannel);

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        DownloadFileTask task = new DownloadFileTask(fileChannel, readableByteChannel);
        
        bar.getProgressBar().progressProperty().bind(task.progressProperty());

        executorService.execute(progress);
        executorService.execute(task);

        executorService.shutdown();
    };
}
