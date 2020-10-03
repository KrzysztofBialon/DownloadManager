package sample.logic.files;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadURLandNameFromFile
{
    public static Map<String, String> readURL(String fileName) throws IOException {
        File file = new File("pausedFiles/pausedFiles.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        List<String> pausedFilesList = new ArrayList<>();
        Map<String, String> map;
        String line;
        while((line = bufferedReader.readLine()) != null)
        {
            pausedFilesList.add(line);
        }

        bufferedReader.close();

        if(pausedFilesList.contains(fileName))
        {
            map = Map.of(fileName, pausedFilesList.get(pausedFilesList.indexOf(fileName)+1));
            return map;
        }
        return null;
    }
}
