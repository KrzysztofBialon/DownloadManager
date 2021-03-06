package sample.logic.thread;

import javafx.application.Platform;
import javafx.concurrent.Task;
import sample.logic.files.crud.RewriteFileAfterFinnishingDld;
import sample.logic.util.fileClass.FileDetailsClass;

import java.io.IOException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

public class DownloadFileTask extends Task {

    private final FileChannel fileChannel;
    private final ReadableByteChannel readableByteChannel;
    private final long fileSize;
    private FileDetailsClass details;

    public DownloadFileTask(FileChannel fileChannel, ReadableByteChannel readableByteChannel, FileDetailsClass details) {
        this.fileChannel = fileChannel;
        this.readableByteChannel = readableByteChannel;
        this.details = details;
        this.fileSize = details.getFileSize();
    }
    @Override
    protected Void call(){
        try
        {
            Platform.runLater(()->details.getBar().getDownloadStatus().setText("Downloading"));
            Platform.runLater(()->details.getBar().getProgressBar().progressProperty().bind(this.progressProperty()));
            //downlaod process
            for(long pos = 0; pos < fileSize; pos += 32)
            {
                try
                {
                    fileChannel.transferFrom(readableByteChannel, pos, Long.MAX_VALUE);
                }
                catch (ClosedChannelException e)
                {
                    fileChannel.close();
                    e.printStackTrace();
                }
                updateProgress(pos, fileSize);
            }

            readableByteChannel.close();
            fileChannel.close();

            Platform.runLater(()->details.getBar().getDownloadStatus().setText("Finnished"));
            //remove file details from pausedFiles.txt after finnishing download
            RewriteFileAfterFinnishingDld.rewrite(this.details);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null; //TODO null!
    }
}
