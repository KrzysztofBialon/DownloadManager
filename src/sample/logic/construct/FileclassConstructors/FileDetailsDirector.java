package sample.logic.construct.FileclassConstructors;

import javafx.application.Platform;
import sample.gui.elements.alert.AlertFactory;
import sample.logic.util.fileClass.FileDetailsClass;

public class FileDetailsDirector
{
    private FileDetailsBuilder fileDetailsBuilder;

    public FileDetailsDirector(FileDetailsBuilder fileDetailsBuilder) {
        this.fileDetailsBuilder = fileDetailsBuilder;
    }

    public void constructFileDetails(){

        try
        {
            fileDetailsBuilder.createHTTPSConnection();
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
