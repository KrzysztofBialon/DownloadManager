package sample.logic.event;

import javafx.concurrent.Task;
import javafx.event.Event;
import javafx.event.EventHandler;
import sample.httpconnection.ResumeDownloadHTTPCon;

import java.io.File;

public class ResumeDownloadEvent implements EventHandler
{

    @Override
    public void handle(Event event)
    {
        //TODO resume get existing bar, update it, link existing elements
        //new ResumeDownloadHTTPCon().setConnection();
    }
}
