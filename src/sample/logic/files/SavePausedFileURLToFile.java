package sample.logic.files;

import sample.logic.util.fileClass.FileDetailsClass;
import java.io.*;

public class SavePausedFileURLToFile
{
     public static void saveToFile(FileDetailsClass detailsClass) throws IOException
     {

       String pausedFilesPath = "pausedFiles/pausedFiles.txt";
       File file = new File(pausedFilesPath);

       file.createNewFile();

       BufferedWriter writer = new BufferedWriter(
               new FileWriter(pausedFilesPath, true));
       //write to file
       writer.write(detailsClass.getFileHeaderName());
       writer.newLine();
       writer.write(String.valueOf(detailsClass.getFileURL()));
       writer.newLine();
       writer.close();
     }
}
