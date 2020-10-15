package sample.logic.files.crud;

import sample.logic.util.fileClass.FileDetailsClass;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class RewriteFileAfterFinnishingDld
{
    public static void rewrite(FileDetailsClass detailsClass) throws IOException {

        Scanner fileScanner = new Scanner(new File("pausedFiles/pausedFiles.txt"));
        List<String> filesSet = new ArrayList<>();

        while (fileScanner.hasNextLine())
        {
            if(fileScanner.nextLine().contains(detailsClass.getFileHeaderName()))
            { //omit downloaded file
                continue;
            }
            filesSet.add(fileScanner.nextLine());
        }
       //clear file
       new PrintWriter("pausedFiles/pausedFiles.txt").close();

       BufferedWriter writer = new BufferedWriter(
               new FileWriter("pausedFiles/pausedFiles.txt", true));
       // write all currently paused files back to file
      filesSet.forEach(line ->
        {
            try {
                writer.write(line);
                writer.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
       writer.close();
    }
}
