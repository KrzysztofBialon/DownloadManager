package sample;

import sample.httpconnection.HTTPConnectionClass;

import java.net.URL;

public class FileDetailsBuilder implements IFileDetailsBuilder
{
    private FileDetailsClass fileDetailsClass;

    public FileDetailsBuilder(URL url, String extension)
    {
        this.fileDetailsClass = new FileDetailsClass(extension, url);
    }

    @Override
    public void createHTTPSConnection() throws Exception {
        HTTPConnectionClass.setConnection(fileDetailsClass);
    }

    @Override
    public void createDownloadBar()
    {
        fileDetailsClass.setBar();
    }

    @Override
    public void createDownloadTask()
    {
        fileDetailsClass.setTask();
    }

    @Override
    public void createDownloadThread()
    {
        fileDetailsClass.setThread();
    }

    public FileDetailsClass getFileDetailsClass() {
        return fileDetailsClass;
    }
}
