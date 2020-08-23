package sample;

import sample.download.SaveFileFromURL;
import sample.download.file.DownloadFileTask;
import sample.httpconnection.HTTPConnectionClass;


public class TaskBuilder {
    public static DownloadFileTask createSaveFileClass(FileDetailsClass details) {
        return SaveFileFromURL.setDestination(details);
    }
}
