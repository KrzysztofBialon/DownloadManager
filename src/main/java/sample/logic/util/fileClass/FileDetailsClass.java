package sample.logic.util.fileClass;

import javafx.application.Platform;
import javafx.concurrent.Task;
import sample.download.SaveFileFromURL;
import sample.gui.elements.alert.FileNotFoundAlert;
import sample.gui.elements.download.bar.DownloadItemBar;
import sample.logic.event.CancelDownloadEvent;

import java.io.FileNotFoundException;
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

    public void setTask(boolean isResume) throws IOException
    {
        this.task = SaveFileFromURL.setDestination(this, isResume).orElseThrow(()-> new RuntimeException()); //TODO is resume change to switch between on situation get rid of runtime exp
    }

    public void setBar() {this.bar = new DownloadItemBar(this);}

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
