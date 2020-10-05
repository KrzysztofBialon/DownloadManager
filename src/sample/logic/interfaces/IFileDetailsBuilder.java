package sample.logic.interfaces;

import sample.logic.util.fileClass.FileDetailsClass;

import java.io.IOException;
import java.net.URL;

public interface IFileDetailsBuilder
{
    void createFileDetailsClass(URL url, String extension, long currentFileSize);
    void createHTTPSConnection() throws Exception;
    void createDownloadBar();
    void createDownloadTask() throws IOException;
    void createDownloadThread();
    FileDetailsClass getFileDetailsClass();
}
