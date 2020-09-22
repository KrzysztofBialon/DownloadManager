package sample.download;

import javafx.application.Platform;
import sample.gui.elements.alert.AlertFactory;
import sample.logic.file.creator.FileCreator;
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

    public static DownloadFileTask setDestination(FileDetailsClass details) throws IOException {

        /*String filename = details.getFileHeaderName()+ "." + details.getExtension();
        String saveFilePath = "C:/Users/User/Downloads" + File.separator + filename;*/ //TODO add file creator method
        File file = FileCreator.createFile(details);
        FileOutputStream fileOutputStream = null;
        ReadableByteChannel readableByteChannel = null;
        FileChannel fileChannel;

        try {
            readableByteChannel = Channels.newChannel(details.getFileURL().openStream());
        } catch (IOException e) {
            Platform.runLater(()-> AlertFactory.createAlert("NoResourceIOAlert").showAndWait());
        }

        try {
            fileOutputStream = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            Platform.runLater(()-> AlertFactory.createAlert("FileNotFoundAlert").showAndWait());
        }

        fileChannel = fileOutputStream.getChannel();

        return new DownloadFileTask(fileChannel, readableByteChannel, details.getFileSize());
    };
}
