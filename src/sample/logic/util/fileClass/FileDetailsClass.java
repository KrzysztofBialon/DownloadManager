package sample.logic.util.fileClass;

import javafx.concurrent.Task;
import sample.download.SaveFileFromURL;
import sample.gui.elements.download.bar.DownloadItemBar;
import sample.logic.event.CancelDownloadEvent;

import java.io.IOException;
import java.net.URL;

public class FileDetailsClass
{
    //TODO fix headername (always null)
    private final URL fileURL;
    private final String extension;
    private String fileHeaderName;
    private long fileSize;;
    private long currentFilesize = 0;
    private Task task;
    private DownloadItemBar bar;
    private Thread thread;

    public FileDetailsClass(String extension, URL url)
    {
        this.extension = extension;
        this.fileURL = url;
    }

    public String getFileHeaderName() {
        return fileHeaderName;
    }

    public URL getFileURL() {
        return fileURL;
    }

    public long getFileSize() {
        return fileSize;
    }

    public String getExtension() {
        return extension;
    }

    public Thread getThread() {
        return thread;
    }

    public DownloadItemBar getBar() {
        return bar;
    }

    public long getCurrentFilesize() {
        return currentFilesize;
    }

    public void setFileHeaderName(String fileHeaderName) {
        this.fileHeaderName = fileHeaderName;
    }

    public void setTask() throws IOException
    {
        this.task = SaveFileFromURL.setDestination(this);
    }

    public void setBar() {
        this.bar = new DownloadItemBar(fileHeaderName, task);
        //this.bar.getProgressBar().progressProperty().bind(task.progressProperty());
    }

    public void setThread()
    {
        thread = new Thread(task);
        thread.setDaemon(true);
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public void setCurrentFilesize(long currentFilesize) {
        this.currentFilesize = currentFilesize;
    }
}
