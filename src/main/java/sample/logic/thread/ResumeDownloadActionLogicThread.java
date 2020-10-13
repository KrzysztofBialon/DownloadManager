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
            ResumeFileDetailsBuilder fileDetailsBuilder = (ResumeFileDetailsBuilder) BuilderFactory.getBuilder(true);
            FileDetailsDirector fileDetailsDirector = new FileDetailsDirector(fileDetailsBuilder);

            try {
                fileDetailsDirector.constructFileDetails(detailsClass.getFileURL(), detailsClass.getExtension(), detailsClass.getCurrentFilesize());
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
            Thread thread = fileDetailsDirector.getFileDetailsClass().getThread();
            thread.setDaemon(true);
            thread.start();
            //new Thread(() -> fileDetailsDirector.getFileDetailsClass().getThread()).start();
        };
        return runnable;
    }
}
