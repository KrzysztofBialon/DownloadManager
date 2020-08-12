package sample.download.progress;

import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

public class DownloadProgressTracker implements Runnable {

    private FileChannel fileChannel;
    private ReadableByteChannel readableByteChannel;

    public DownloadProgressTracker(FileChannel fileChannel, ReadableByteChannel readableByteChannel) {
        this.fileChannel = fileChannel;
        this.readableByteChannel = readableByteChannel;
    }

    @Override
    public void run() {
        try
        {
            while(readableByteChannel.isOpen())
                System.out.println(fileChannel.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
