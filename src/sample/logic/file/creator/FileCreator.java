package sample.logic.file.creator;

import sample.logic.util.fileClass.FileDetailsClass;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class FileCreator
{
    public static File createFile(FileDetailsClass details) throws IOException {

        String filename = details.getFileHeaderName() + "." + details.getExtension();

        while (true) {

            File file = new File("C:/Users/User/Downloads" + File.separator + filename);
            if (file.createNewFile())  return file;

            filename = UUID.randomUUID() + "." + details.getExtension();
        }
    }
}
