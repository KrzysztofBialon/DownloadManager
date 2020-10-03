package sample.logic.files;

import java.io.File;

public class CheckFileSize
{
    public static long checkSize(String filename)
    {
        File searchFile = new File("C:/Users/User/Downloads" + File.separator + filename);
        return searchFile.exists() ? searchFile.length() : null;
    }
}
