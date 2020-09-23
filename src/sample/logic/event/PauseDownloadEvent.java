package sample.logic.event;

import javafx.concurrent.Task;
import javafx.event.Event;
import javafx.event.EventHandler;

public class PauseDownloadEvent implements EventHandler
{
    private final Task downloadTask;

    public PauseDownloadEvent(Task downloadTask) {
        this.downloadTask = downloadTask;;
    }


    @Override
    public void handle(Event event)
    {
        downloadTask.cancel();
    }
}
