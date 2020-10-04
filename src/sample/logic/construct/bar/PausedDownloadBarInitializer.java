package sample.logic.construct.bar;

import sample.logic.files.CheckFileSize;
import sample.logic.util.fileClass.FileDetailsClass;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.List;

public class PausedDownloadBarInitializer
{
    public static FileDetailsClass initializeDetailsClass(String[] extracted) throws IOException {

        FileDetailsClass detailsClass = new FileDetailsClass();

        detailsClass.setFileHeaderName(key);
        detailsClass.setFileURL(url);
        detailsClass.setCurrentFilesize(fileSize);

        return detailsClass;
    }
}
