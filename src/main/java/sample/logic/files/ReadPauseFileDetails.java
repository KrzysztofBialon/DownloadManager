package sample.logic.files;

import java.io.*;
import java.util.*;

public class ReadPauseFileDetails
{
    public static List<String> readPausedFilesFromFile() throws IOException {

        List<String>  pausedFilesDetailsList = new ArrayList<>();
        File file = new File("pausedFiles/pausedFiles.txt");
        if(!file.exists()){return pausedFilesDetailsList;}
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        while((line = bufferedReader.readLine()) != null)
        {
            pausedFilesDetailsList.add(line);
        }

        bufferedReader.close();

        return pausedFilesDetailsList;
    }
}
