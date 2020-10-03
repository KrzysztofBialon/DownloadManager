package sample.logic.files;

import java.io.*;
import java.net.URL;
import java.util.*;

public class ReadURLandNameFromFile
{
    public static Map<String, String> readPausedFilesFromFile() throws IOException {
        File file = new File("pausedFiles/pausedFiles.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        Map<String, String> map = new HashMap<>();
        String line;
        while((line = bufferedReader.readLine()) != null)
        {
            map.put(line, bufferedReader.readLine());
        }

        bufferedReader.close();

        return map;
    }
}
