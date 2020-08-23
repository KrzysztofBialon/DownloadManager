package sample.download;

import sample.FileDetailsClass;
import sample.download.file.DownloadFileTask;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

public class SaveFileFromURL{

   /* private FileDetailsClass details;
    private String filename;
    private String saveFilePath;
    private FileChannel fileChannel = null;
    private FileOutputStream fileOutputStream = null;
    private ReadableByteChannel readableByteChannel = null;

    public SaveFileFromURL(FileDetailsClass details) {
        this.details = details;
    }*/

    public static DownloadFileTask setDestination(FileDetailsClass details) {

        String filename = details.getFileHeaderName() + details.getExtension();
        String saveFilePath = "C:/Users/User/Downloads" + File.separator + filename;
        FileOutputStream fileOutputStream = null;
        ReadableByteChannel readableByteChannel = null;
        FileChannel fileChannel;

        try {
            readableByteChannel = Channels.newChannel(details.getFileURL().openStream());
        } catch (IOException e) {
            e.printStackTrace();;
        }

        try {
            fileOutputStream = new FileOutputStream(saveFilePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        fileChannel = fileOutputStream.getChannel();
        return new DownloadFileTask(fileChannel, readableByteChannel);
        /*DownloadProgressTracker progress = new DownloadProgressTracker(fileChannel, readableByteChannel);

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        DownloadFileTask task = new DownloadFileTask(fileChannel, readableByteChannel);

        executorService.execute(progress);
        executorService.execute(task);

        executorService.shutdown();*/
    };
}
