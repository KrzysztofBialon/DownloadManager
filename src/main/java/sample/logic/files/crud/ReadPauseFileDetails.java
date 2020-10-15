package sample.logic.files.crud;

import java.io.*;
import java.util.*;

public class ReadPauseFileDetails
{
    public static List<String> readPausedFilesFromFile() throws IOException {
        //reads pausedFiles.txt if exists, file and returns its content as a list
        List<String>  pausedFilesDetailsList = new ArrayList<>();
        File file = new File("pausedFiles/pausedFiles.txt");
        String line;

        if(!file.exists()){return pausedFilesDetailsList;}

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));


        while((line = bufferedReader.readLine()) != null)
        {
            pausedFilesDetailsList.add(line);
        }

        bufferedReader.close();

        return pausedFilesDetailsList;
    }
}
