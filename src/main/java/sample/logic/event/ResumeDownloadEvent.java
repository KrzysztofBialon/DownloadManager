package sample.logic.event;

import javafx.event.Event;
import javafx.event.EventHandler;
import sample.logic.thread.DownloadActionLogicThread;
import sample.logic.thread.ResumeDownloadActionLogicThread;
import sample.logic.util.fileClass.FileDetailsClass;

import java.util.concurrent.ExecutorService;

public class ResumeDownloadEvent implements EventHandler
{
    private FileDetailsClass detailsClass;
    private final ExecutorService executorService;
//TODO inject threadpool from controller
    public ResumeDownloadEvent(FileDetailsClass detailsClass, ExecutorService executorService) {
        this.detailsClass = detailsClass;
        this.executorService = executorService;
    }

    @Override
    public void handle(Event event)
    {
        //TODO resume get existing bar, update it, link existing elements
        //TODO passs thread pool here
        Thread downloadAction = new Thread(ResumeDownloadActionLogicThread.
                downloadActionThread(detailsClass.getFileURL(), detailsClass.getExtension()));//TODO pass filesize

        executorService.execute(downloadAction);
    }
}
