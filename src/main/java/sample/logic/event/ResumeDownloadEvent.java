package sample.logic.event;

import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.layout.VBox;
import sample.logic.thread.DownloadActionLogicThread;
import sample.logic.thread.ResumeDownloadActionLogicThread;
import sample.logic.util.fileClass.FileDetailsClass;

import java.util.concurrent.ExecutorService;

public class ResumeDownloadEvent implements EventHandler
{
    private FileDetailsClass detailsClass;
    private final ExecutorService executorService;
    private VBox wrapper;

    public ResumeDownloadEvent(FileDetailsClass detailsClass, ExecutorService executorService, VBox wrapper) {
        this.detailsClass = detailsClass;
        this.executorService = executorService;
        this.wrapper = wrapper;
    }

    @Override
    public void handle(Event event)
    {
        Thread downloadAction = new Thread(ResumeDownloadActionLogicThread.downloadActionThread(detailsClass));

        Platform.runLater(()->wrapper.getChildren().remove(detailsClass.getBar().getWrapper()));
        Platform.runLater(()->wrapper.getChildren().add(detailsClass.getBar().getWrapper()));
        Platform.runLater(()->detailsClass.getBar().getDownloadStatus().setText("Downloading"));
        Platform.runLater(()->detailsClass.getBar().getProgressBar().progressProperty().bind(detailsClass.getTask().progressProperty()));

        executorService.execute(downloadAction);
    }
}
