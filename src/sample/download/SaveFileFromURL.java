package sample.download;

import javafx.application.Platform;
import sample.gui.elements.alert.InformationAlert;
import sample.logic.util.fileClass.FileDetailsClass;
import sample.download.file.DownloadFileTask;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

public class SaveFileFromURL{

    public static DownloadFileTask setDestination(FileDetailsClass details) {

        String filename = details.getFileHeaderName()+ "." + details.getExtension();
        String saveFilePath = "C:/Users/User/Downloads" + File.separator + filename;
        FileOutputStream fileOutputStream = null;
        ReadableByteChannel readableByteChannel = null;
        FileChannel fileChannel;

        try {
            readableByteChannel = Channels.newChannel(details.getFileURL().openStream());
        } catch (IOException e) {
            Platform.runLater(()->{
                InformationAlert informationAlert = new InformationAlert("Cannot open connection",
                        "There is no files to download under given URL. Check URL.");
                informationAlert.showAndWait();
            });
        }

        try {
            fileOutputStream = new FileOutputStream(saveFilePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        fileChannel = fileOutputStream.getChannel();

        return new DownloadFileTask(fileChannel, readableByteChannel, details.getFileSize());
    };
}
