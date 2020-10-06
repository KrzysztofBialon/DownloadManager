package sample.logic.files;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class CheckIfFileExists
{
    public static boolean exists(String filename)
    {
        return Files.exists(Path.of("C:/Users/User/Downloads" + File.separator + filename));
    }
}
