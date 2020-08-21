package sample.download.file;

import javafx.concurrent.Service;
import javafx.concurrent.Task;

import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

public class DownloadFileService extends Service {

    private FileChannel fileChannel;
    private ReadableByteChannel readableByteChannel;

    public DownloadFileService(FileChannel fileChannel, ReadableByteChannel readableByteChannel) {
        this.fileChannel = fileChannel;
        this.readableByteChannel = readableByteChannel;
    }

    @Override
    protected Task createTask() {
        try
        {
            fileChannel.transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
            readableByteChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
