package sample;

import sample.download.SaveFileFromURL;
import sample.download.file.DownloadFileTask;
import sample.httpconnection.HTTPConnectionClass;


public class ConnectionBuilder {
    public static DownloadFileTask createSaveFileClass(FileDetailsClass details) throws Exception {
        return SaveFileFromURL.setDestination(details);
    }
}
