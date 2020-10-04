package sample.logic.construct.bar;

import sample.logic.files.CheckFileSize;
import sample.logic.util.fileClass.FileDetailsClass;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedHashMap;

public class PausedDownloadBarInitializer
{
    public static FileDetailsClass initializeDetailsClass(LinkedHashMap<String, String> map, int iterator) throws IOException {

        String key = map.get(map.keySet().toArray()[iterator]);
        long fileSize = CheckFileSize.checkSize(map.get(key));
        URL url = new URL(map.get(key));
        FileDetailsClass detailsClass = new FileDetailsClass();

        detailsClass.setFileHeaderName(key);
        detailsClass.setFileURL(url);
        detailsClass.setCurrentFilesize(fileSize);

        return detailsClass;
    }
}
