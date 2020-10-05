package sample.logic.construct.FileclassConstructors;

import sample.httpconnection.NewHTTPConnectionClass;
import sample.httpconnection.ResumeDownloadHTTPCon;
import sample.logic.interfaces.IFileDetailsBuilder;
import sample.logic.util.fileClass.FileDetailsClass;
import java.io.IOException;
import java.net.URL;

public class ResumeFileDetailsBuilder implements IFileDetailsBuilder
{
    private FileDetailsClass fileDetailsClass;

    @Override
    public void createFileDetailsClass(URL url, String extension, long currentFileSize)
    {
        this.fileDetailsClass = new FileDetailsClass();
        this.fileDetailsClass.setFileURL(url);
        this.fileDetailsClass.setExtension(extension);
        this.fileDetailsClass.setCurrentFilesize(currentFileSize);
    }

    @Override
    public void createHTTPSConnection() throws Exception {
        new ResumeDownloadHTTPCon().setConnection(this.fileDetailsClass);
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
