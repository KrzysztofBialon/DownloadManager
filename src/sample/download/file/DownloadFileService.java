package sample.download.file;

import javafx.concurrent.Service;
import javafx.concurrent.Task;

import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

public class DownloadFileService extends Service {

    private final FileChannel fileChannel;
    private final ReadableByteChannel readableByteChannel;

    public DownloadFileService(FileChannel fileChannel, ReadableByteChannel readableByteChannel) {
        this.fileChannel = fileChannel;
        this.readableByteChannel = readableByteChannel;
    }

    @Override
    protected Task createTask() {
        return new Task() {
            @Override
            protected Object call() throws Exception {
                try
                {
                    fileChannel.transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
                    readableByteChannel.close();
                    return true;
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
        };
    }
}
