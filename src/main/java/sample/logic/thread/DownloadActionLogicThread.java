package sample.logic.thread;

import javafx.application.Platform;
import javafx.scene.layout.VBox;
import sample.logic.construct.FileclassConstructors.NewFileDetailsBuilder;
import sample.logic.construct.FileclassConstructors.FileDetailsDirector;
import sample.logic.construct.factory.BuilderFactory;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DownloadActionLogicThread
{
    //private static ExecutorService downloadPool = Executors.newFixedThreadPool(2);

    public static Runnable downloadActionThread(URL url, String extension, VBox downloadListWrapper)
    {
        Runnable runnable =() -> {
//TODO implement differet thread forresume and for start, start stays the same, resume updates existing bar not adding new
            NewFileDetailsBuilder fileDetailsBuilder = (NewFileDetailsBuilder) BuilderFactory.getBuilder(false);
            FileDetailsDirector fileDetailsDirector = new FileDetailsDirector(fileDetailsBuilder);

            try {
                fileDetailsDirector.constructFileDetails(url, extension, 0);
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
            Platform.runLater(() -> downloadListWrapper.getChildren().add(fileDetailsDirector.getFileDetailsClass().getBar().getWrapper()));
            new Thread(() -> fileDetailsDirector.getFileDetailsClass().getThread()).start();
        };
        return runnable;
    }
}
