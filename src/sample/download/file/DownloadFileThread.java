package sample.download.file;

import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

public class DownloadFileThread implements Runnable {

    private FileChannel fileChannel;
    private ReadableByteChannel readableByteChannel;

    public DownloadFileThread(FileChannel fileChannel, ReadableByteChannel readableByteChannel) {
        this.fileChannel = fileChannel;
        this.readableByteChannel = readableByteChannel;
    }

    @Override
    public void run() {
        try
        {
            fileChannel.transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
            readableByteChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
