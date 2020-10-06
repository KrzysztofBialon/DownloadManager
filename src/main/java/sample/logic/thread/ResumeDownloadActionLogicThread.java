package sample.logic.thread;

import javafx.application.Platform;
import javafx.scene.layout.VBox;
import sample.logic.construct.FileclassConstructors.FileDetailsDirector;
import sample.logic.construct.FileclassConstructors.NewFileDetailsBuilder;
import sample.logic.construct.FileclassConstructors.ResumeFileDetailsBuilder;
import sample.logic.construct.factory.BuilderFactory;
import java.net.URL;

public class ResumeDownloadActionLogicThread
{
    public static Runnable downloadActionThread(URL url, String extension)
    {
        Runnable runnable =() -> {
            ResumeFileDetailsBuilder fileDetailsBuilder = (ResumeFileDetailsBuilder) BuilderFactory.getBuilder(true);
            FileDetailsDirector fileDetailsDirector = new FileDetailsDirector(fileDetailsBuilder);

            try {
                fileDetailsDirector.constructFileDetails(url, extension, fileDetailsDirector.getFileDetailsClass().getCurrentFilesize());
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }

            new Thread(() -> fileDetailsDirector.getFileDetailsClass().getThread()).start();
        };
        return runnable;
    }
}
