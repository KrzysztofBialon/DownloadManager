package sample.logic.construct.FileclassConstructors;

import sample.httpconnection.HTTPConnectionClass;
import sample.logic.interfaces.IFileDetailsBuilder;
import sample.logic.util.fileClass.FileDetailsClass;

import java.io.IOException;
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
        new HTTPConnectionClass().setConnection(fileDetailsClass);

    }

    @Override
    public void createDownloadBar()
    {
        fileDetailsClass.setBar();
    }

    @Override
    public void createDownloadTask() throws IOException {
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
