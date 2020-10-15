package sample.logic.files.crud;

import sample.logic.util.fileClass.FileDetailsClass;
import java.io.*;

public class SavePausedFileDetailsToFile
{
     public static void saveToFile(FileDetailsClass detailsClass) throws IOException
     {

       String pausedFilesPath = "pausedFiles/pausedFiles.txt";
       File file = new File(pausedFilesPath);

       file.createNewFile();

       String details =
                       detailsClass.getFileHeaderName() + " " +
                       detailsClass.getFileURL() + " " +
                       detailsClass.getFileSize();

       BufferedWriter writer = new BufferedWriter(
               new FileWriter(pausedFilesPath, true));

       writer.write(details);
       writer.newLine();
       writer.close();
     }
}
