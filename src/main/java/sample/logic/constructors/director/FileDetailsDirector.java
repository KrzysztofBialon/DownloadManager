package sample.logic.constructors.director;

import javafx.application.Platform;
import sample.logic.constructors.factory.AlertFactory;
import sample.logic.interfaces.IFileDetailsBuilder;
import sample.logic.util.fileClass.FileDetailsClass;

import java.io.IOException;
import java.net.URL;

public class FileDetailsDirector
{
    private IFileDetailsBuilder fileDetailsBuilder;

    public FileDetailsDirector(IFileDetailsBuilder fileDetailsBuilder) {
        this.fileDetailsBuilder = fileDetailsBuilder;
    }

    public void constructFileDetails(URL url, String extension, long currentFileSize, String name) throws IOException {

        fileDetailsBuilder.createFileDetailsClass(url, extension, currentFileSize, name);
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
