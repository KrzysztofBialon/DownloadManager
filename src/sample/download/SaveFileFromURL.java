package sample.download;

import javafx.application.Platform;
import sample.gui.elements.alert.AlertFactory;
import sample.logic.file.creator.FileCreator;
import sample.logic.util.fileClass.FileDetailsClass;
import sample.logic.thread.DownloadFileTask;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

public class SaveFileFromURL{

    public static DownloadFileTask setDestination(FileDetailsClass details) throws IOException {

        File file = FileCreator.createFile(details);
        FileOutputStream fileOutputStream;
        ReadableByteChannel readableByteChannel;
        FileChannel fileChannel;

        try {
            readableByteChannel = Channels.newChannel(details.getFileURL().openStream());
        } catch (IOException e) {
            Platform.runLater(()-> AlertFactory.createAlert("NoResourceIOAlert").showAndWait());
            return null;
        }

        try {
            fileOutputStream = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            Platform.runLater(()-> AlertFactory.createAlert("FileNotFoundAlert").showAndWait());
            return null;
        }

        fileChannel = fileOutputStream.getChannel();
        return new DownloadFileTask(fileChannel, readableByteChannel, details);
    };
}
