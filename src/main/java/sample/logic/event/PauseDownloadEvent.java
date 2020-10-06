package sample.logic.event;

import javafx.concurrent.Task;
import javafx.event.Event;
import javafx.event.EventHandler;
import sample.logic.files.SavePausedFileURLToFile;
import sample.logic.util.fileClass.FileDetailsClass;

import java.io.IOException;

public class PauseDownloadEvent implements EventHandler
{
    private FileDetailsClass detailsClass;

    public PauseDownloadEvent(FileDetailsClass detailsClass) {
        this.detailsClass = detailsClass;;
    }


    @Override
    public void handle(Event event)
    {
        detailsClass.getTask().cancel();
        try {
            SavePausedFileURLToFile.saveToFile(detailsClass);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
