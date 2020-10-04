package sample.logic.interfaces;

import java.io.IOException;
import java.net.URL;

public interface IFileDetailsBuilder
{
    void createFileDetailsClass(URL url, String extension);
    void createHTTPSConnection() throws Exception;
    void createDownloadBar();
    void createDownloadTask() throws IOException;
    void createDownloadThread();
}
