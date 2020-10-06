package sample.logic.files;

import org.apache.commons.io.FilenameUtils;
import java.io.File;

public class CheckExtension
{
    public static String getExtension(String filename)
    {
        return FilenameUtils.getExtension("C:/Users/User/Downloads" + File.separator + filename);
    }
}
