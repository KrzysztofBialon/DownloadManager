package sample.logic.util.fileClass;

import javafx.application.Platform;
import javafx.concurrent.Task;
import sample.download.SaveFileFromURL;
import sample.gui.elements.download.bar.DownloadItemBar;
import sample.logic.event.CancelDownloadEvent;

import java.io.IOException;
import java.net.URL;

public class FileDetailsClass
{
    //TODO fix headername (always null)
    private URL fileURL;
    private String extension;
    private String fileHeaderName;
    private long fileSize;;
    private long currentFilesize = 0;
    private Task task;
    private DownloadItemBar bar;
    private Thread thread;



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
        System.out.println("getThread");
        return thread;
    }

    public DownloadItemBar getBar() {
        return bar;
    }

    public long getCurrentFilesize() {
        return currentFilesize;
    }

    public Task getTask() {
        return task;
    }

    public void setFileURL(URL fileURL) {
        this.fileURL = fileURL;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public void setFileHeaderName(String fileHeaderName) {
        this.fileHeaderName = fileHeaderName;
    }

    public void setTask() throws IOException
    {
        this.task = SaveFileFromURL.setDestination(this);
    }

    public void setBar() {
        this.bar = new DownloadItemBar(this);
        //Platform.runLater(()->this.bar.getProgressBar().progressProperty().setValue(fileSize/currentFilesize));
        //Platform.runLater(()->this.bar.getProgressBar().progressProperty().bind(task.progressProperty()));
        //TODO check if works properly
    }

    public void setThread()
    {
        thread = new Thread(task);
        thread.setDaemon(true);
        System.out.println("setthread");
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public void setCurrentFilesize(long currentFilesize) {
        this.currentFilesize = currentFilesize;
    }
}