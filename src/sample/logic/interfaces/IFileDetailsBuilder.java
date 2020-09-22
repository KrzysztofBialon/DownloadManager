package sample.logic.interfaces;

import java.io.IOException;

public interface IFileDetailsBuilder
{
    void createHTTPSConnection() throws Exception;
    void createDownloadBar();
    void createDownloadTask() throws IOException;
    void createDownloadThread();
}
