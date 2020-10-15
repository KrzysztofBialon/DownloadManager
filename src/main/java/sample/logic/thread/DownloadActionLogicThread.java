package sample.logic.thread;

import javafx.application.Platform;
import javafx.scene.layout.VBox;
import sample.logic.constructors.builder.NewFileDetailsBuilder;
import sample.logic.constructors.director.FileDetailsDirector;
import sample.logic.constructors.factory.BuilderFactory;
import sample.logic.files.crud.SavePausedFileDetailsToFile;

import java.io.IOException;
import java.net.URL;

public class DownloadActionLogicThread
{
    //private static ExecutorService downloadPool = Executors.newFixedThreadPool(2);

    public static Runnable downloadActionThread(URL url, String extension, VBox downloadListWrapper)
    {
        Runnable runnable =() -> {
            NewFileDetailsBuilder fileDetailsBuilder = (NewFileDetailsBuilder) BuilderFactory.getBuilder(false);
            FileDetailsDirector fileDetailsDirector = new FileDetailsDirector(fileDetailsBuilder);

            try {
                fileDetailsDirector.constructFileDetails(url, extension, 0, "");
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
            Platform.runLater(() -> downloadListWrapper.getChildren().add(fileDetailsDirector.getFileDetailsClass().getBar().getWrapper()));
            Thread thread = fileDetailsDirector.getFileDetailsClass().getThread();
            // save currently dowloading file to fiels repo
            try {
                SavePausedFileDetailsToFile.saveToFile(fileDetailsDirector.getFileDetailsClass());
            } catch (IOException e) {
                e.printStackTrace();
            }
            thread.setDaemon(true);
            thread.start();
        };
        return runnable;
    }
}
