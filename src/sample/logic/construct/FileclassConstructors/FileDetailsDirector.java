package sample.logic.construct.FileclassConstructors;

import javafx.application.Platform;
import sample.gui.elements.alert.AlertFactory;
import sample.logic.construct.factory.BuilderFactory;
import sample.logic.util.fileClass.FileDetailsClass;

import java.io.IOException;

public class FileDetailsDirector
{
    private FileDetailsBuilder fileDetailsBuilder;

    public FileDetailsDirector(FileDetailsBuilder fileDetailsBuilder) {
        this.fileDetailsBuilder = fileDetailsBuilder;
    }

    public void constructFileDetails(boolean isResume) throws IOException {

        //TODO rearrange builder to be build in factory in constructor
        try
        {
            BuilderFactory.getBuilder(isResume).createHTTPSConnection();
        } catch (Exception e)
        {
            Platform.runLater(()-> AlertFactory.createAlert("ProtocolAlert"));
            return;
        }
        fileDetailsBuilder.createDownloadTask();
        fileDetailsBuilder.createDownloadBar();
        fileDetailsBuilder.createDownloadThread();
    }

    public FileDetailsClass getFileDetailsClass()
    {
        return this.fileDetailsBuilder.getFileDetailsClass();
    }
}
