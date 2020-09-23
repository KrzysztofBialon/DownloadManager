package sample.logic.event;

import javafx.concurrent.Task;
import javafx.event.Event;
import javafx.event.EventHandler;
import java.io.File;

public class ResumeDownloadEvent implements EventHandler
{
    private final Task downloadTask;
    private final String filename;

    public ResumeDownloadEvent(Task downloadTask, String filename) {
        this.downloadTask = downloadTask;
        this.filename = filename;

    }

    @Override
    public void handle(Event event)
    {

        File file = new File("C:/Users/User/Downloads" + File.separator + filename);
        if(file.exists())
        {
            long fileSize = file.length();
        } else
        {
            System.out.println("C:/Users/User/Downloads" + File.separator + filename);
            System.out.println("File no longer exists.");//TODO add alert
        }

    }
}
