package sample.logic.thread;

import javafx.application.Platform;
import javafx.scene.layout.VBox;
import sample.logic.construct.FileclassConstructors.FileDetailsDirector;
import sample.logic.construct.FileclassConstructors.NewFileDetailsBuilder;
import sample.logic.construct.FileclassConstructors.ResumeFileDetailsBuilder;
import sample.logic.construct.factory.BuilderFactory;
import sample.logic.util.fileClass.FileDetailsClass;

import java.net.URL;

public class ResumeDownloadActionLogicThread
{
    public static Runnable downloadActionThread(FileDetailsClass detailsClass)
    {
        Runnable runnable =() -> {
            Thread thread = detailsClass.getThread();
            thread.setDaemon(true);
            thread.start();
        };
        return runnable;
    }
}
