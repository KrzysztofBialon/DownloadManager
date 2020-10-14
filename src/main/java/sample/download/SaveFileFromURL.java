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
import java.util.Optional;

public class SaveFileFromURL{

    public static Optional<DownloadFileTask> setDestination(FileDetailsClass details, boolean isResume) throws IOException {

        File file;
        FileOutputStream fileOutputStream;
        ReadableByteChannel readableByteChannel;
        FileChannel fileChannel;

        file = isResume ?
                new File("C:/Users/User/Downloads" + File.separator + details.getFileHeaderName())
                : FileCreator.createFile(details);

        try {
            readableByteChannel = Channels.newChannel(details.getFileURL().openStream());
        } catch (IOException e) {
            Platform.runLater(()-> AlertFactory.createAlert("NoResourceIOAlert").showAndWait());
            return Optional.empty(); //TODO get rid of nulls in app
        }

        try {
            fileOutputStream = new FileOutputStream(file);
            fileChannel = fileOutputStream.getChannel();
        } catch (FileNotFoundException e) {
            Platform.runLater(()-> AlertFactory.createAlert("FileNotFoundAlert").showAndWait());
            return Optional.empty();
        }


        return Optional.of(new DownloadFileTask(fileChannel, readableByteChannel, details));
    };
}
