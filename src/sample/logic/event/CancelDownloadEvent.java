package sample.logic.event;

import javafx.concurrent.Task;
import javafx.event.Event;
import javafx.event.EventHandler;

import java.io.File;

public class CancelDownloadEvent implements EventHandler
{
    private final Task downloadTask;
    private final String filename;

    public CancelDownloadEvent(Task downloadTask, String filename) {
        this.downloadTask = downloadTask;
        this.filename = filename;

    }

    @Override
    public void handle(Event event)
    {
        System.out.println("C:/Users/User/Downloads" + File.separator + filename);
        downloadTask.cancel();
        File file = new File("C:/Users/User/Downloads" + File.separator + filename);
        if(file.delete())
        {
            System.out.println("deleted");
        } else {
            System.out.println("nie usuniete");
        }
    }
}
