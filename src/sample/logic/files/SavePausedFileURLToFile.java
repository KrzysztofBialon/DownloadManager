package sample.logic.files;

import sample.logic.util.fileClass.FileDetailsClass;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class SavePausedFileURLToFile
{
 public static void saveToFile(FileDetailsClass detailsClass){
   Path pausedFiles = Paths.get("pausedFiles/pausedFiles.txt");
   List<String> fileDetails = Arrays.asList(detailsClass.getFileHeaderName(), detailsClass.getFileURL()); //TODO try serialize whole object
   if(!Files.exists(pausedFiles, LinkOption.NOFOLLOW_LINKS))
   {
       Files.write(pausedFiles,)
   }

 }
}
