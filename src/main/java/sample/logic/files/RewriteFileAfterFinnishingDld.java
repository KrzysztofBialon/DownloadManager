package sample.logic.files;

import sample.logic.util.fileClass.FileDetailsClass;

import java.io.*;
import java.util.HashSet;
import java.util.Scanner;

public class RewriteFileAfterFinnishingDld
{
    public static void rewrite(FileDetailsClass detailsClass) throws IOException {

        Scanner fileScanner = new Scanner(new File("pausedFiles/pausedFiles.txt"));
        HashSet<String> filesSet = new HashSet<>();

        while (fileScanner.hasNext())
        {
            if(fileScanner.next().contains(detailsClass.getFileHeaderName()))
            {
                continue;
            }
            filesSet.add(fileScanner.next());
        }

       new PrintWriter("pausedFiles/pausedFiles.txt").close();

       BufferedWriter writer = new BufferedWriter(
               new FileWriter("pausedFiles/pausedFiles.txt", true));

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
