package sample.logic.thread;

import javafx.application.Platform;
import javafx.scene.layout.VBox;
import sample.logic.construct.FileclassConstructors.FileDetailsBuilder;
import sample.logic.construct.FileclassConstructors.FileDetailsDirector;

import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DownloadActionLogicThread
{
    private static ExecutorService downloadPool = Executors.newFixedThreadPool(2);

    public static Runnable downloadActionThread(URL url, String extension, VBox downloadListWrapper)
    {
        Runnable runnable =() -> {
            FileDetailsBuilder fileDetailsBuilder = new FileDetailsBuilder();
            fileDetailsBuilder.createFileDetailsClass(url, extension);
            FileDetailsDirector fileDetailsDirector = new FileDetailsDirector(fileDetailsBuilder);
            try {
                fileDetailsDirector.constructFileDetails(false);
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
            Platform.runLater(() -> downloadListWrapper.getChildren().add(fileDetailsDirector.getFileDetailsClass().getBar().getWrapper()));
            downloadPool.execute(fileDetailsDirector.getFileDetailsClass().getThread());
        };
        return runnable;
    }
}
