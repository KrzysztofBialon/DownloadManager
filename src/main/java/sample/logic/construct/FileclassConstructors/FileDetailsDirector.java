package sample.logic.construct.FileclassConstructors;

import javafx.application.Platform;
import sample.gui.elements.alert.AlertFactory;
import sample.logic.construct.factory.BuilderFactory;
import sample.logic.interfaces.IFileDetailsBuilder;
import sample.logic.util.fileClass.FileDetailsClass;

import java.io.IOException;
import java.net.URL;

public class FileDetailsDirector
{
    private IFileDetailsBuilder fileDetailsBuilder; //TODO change to Interface to be chosen in factory

    public FileDetailsDirector(IFileDetailsBuilder fileDetailsBuilder) {
        this.fileDetailsBuilder = fileDetailsBuilder;
    }
//TODO current filesize injection rethink delete fromhere
    public void constructFileDetails(URL url, String extension, long currentFileSize) throws IOException {

        fileDetailsBuilder.createFileDetailsClass(url, extension, currentFileSize);
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
