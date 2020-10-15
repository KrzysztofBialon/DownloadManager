package sample.logic.files.check;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CheckFileSize
{
    public static long checkSize(String filename) throws IOException
    {
        return Files.size(Path.of("C:/Users/User/Downloads" + File.separator + filename));
    }
}
