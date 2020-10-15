package sample.logic.event;

import javafx.event.Event;
import javafx.event.EventHandler;
import sample.logic.util.fileClass.FileDetailsClass;

public class PauseDownloadEvent implements EventHandler
{
    private FileDetailsClass detailsClass;

    public PauseDownloadEvent(FileDetailsClass detailsClass) {this.detailsClass = detailsClass;}

    @Override
    public void handle(Event event) {detailsClass.getTask().cancel();}
}
