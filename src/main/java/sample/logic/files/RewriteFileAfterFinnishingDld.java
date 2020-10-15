package sample.logic.files;

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
            {
                continue;
            }
            filesSet.add(fileScanner.nextLine());
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
