package sample.logic.construct.FileclassConstructors;

import javafx.application.Platform;
import sample.gui.elements.alert.InformationAlert;
import sample.logic.util.fileClass.FileDetailsClass;

public class FileDetailsDirector
{
    private FileDetailsBuilder fileDetailsBuilder;

    public FileDetailsDirector(FileDetailsBuilder fileDetailsBuilder) {
        this.fileDetailsBuilder = fileDetailsBuilder;
    }

    public void constructFileDetails(){

        try {
            fileDetailsBuilder.createHTTPSConnection();
        } catch (Exception e) {
            Platform.runLater(()->{
                InformationAlert informationAlert = new InformationAlert("Connection issue",
                        "Server not responding correctly.");
                informationAlert.showAndWait();
            });
            System.out.println("Connection issue"); //TODO show alert
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
