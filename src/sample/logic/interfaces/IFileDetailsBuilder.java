package sample.logic.interfaces;

public interface IFileDetailsBuilder
{
    void createHTTPSConnection() throws Exception;
    void createDownloadBar();
    void createDownloadTask();
    void createDownloadThread();
}
