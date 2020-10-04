package sample.logic.files;

import java.io.*;
import java.util.*;

public class ReadPauseFileDetails
{
    public static List<String> readPausedFilesFromFile() throws IOException {

        File file = new File("pausedFiles/pausedFiles.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        List<String>  pausedFilesDetailsList = new ArrayList<>();
        String line;

        while((line = bufferedReader.readLine()) != null)
        {
            pausedFilesDetailsList.add(line);
        }

        bufferedReader.close();

        return pausedFilesDetailsList;
    }
}
