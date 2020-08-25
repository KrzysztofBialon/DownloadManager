package sample.download.file;

import javafx.concurrent.Task;

import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

public class DownloadFileTask extends Task {

    private final FileChannel fileChannel;
    private final ReadableByteChannel readableByteChannel;
    private final long fileSize;

    public DownloadFileTask(FileChannel fileChannel, ReadableByteChannel readableByteChannel, long fileSize) {
        this.fileChannel = fileChannel;
        this.readableByteChannel = readableByteChannel;
        this.fileSize = fileSize;
    }
    @Override
    protected Void call(){
        try
        {
            for(long pos = 0; pos < fileSize; pos += 32)
            {
                fileChannel.transferFrom(readableByteChannel, pos, Long.MAX_VALUE);
                updateProgress(pos, fileSize);
            }
            readableByteChannel.close();
            fileChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
