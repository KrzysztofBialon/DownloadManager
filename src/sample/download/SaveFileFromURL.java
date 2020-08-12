package sample.download;

import sample.download.file.DownloadFileThread;
import sample.download.progress.DownloadProgressTracker;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SaveFileFromURL {

    public static void saveFile(String fileURL, URL url) throws IOException {

        String fileExtension ="exe";

        String filename = "test." + fileExtension;

        String saveFilePath = "C:/Users/User/Downloads" + File.separator + filename;

        ReadableByteChannel readableByteChannel = Channels.newChannel(url.openStream());

        FileOutputStream fileOutputStream = new FileOutputStream(saveFilePath);

        FileChannel fileChannel = fileOutputStream.getChannel();

        DownloadFileThread download = new DownloadFileThread(fileChannel, readableByteChannel);

        DownloadProgressTracker progress = new DownloadProgressTracker(fileChannel, readableByteChannel);


        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.execute(progress);
        executorService.execute(download);

        executorService.shutdown();
    }
}
