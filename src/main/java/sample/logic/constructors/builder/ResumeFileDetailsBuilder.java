package sample.logic.constructors.builder;

import sample.httpconnection.ResumeDownloadHTTPCon;
import sample.logic.interfaces.IFileDetailsBuilder;
import sample.logic.util.fileClass.FileDetailsClass;
import java.io.IOException;
import java.net.URL;

public class ResumeFileDetailsBuilder implements IFileDetailsBuilder
{
    private FileDetailsClass fileDetailsClass;

    @Override
    public void createFileDetailsClass(URL url, String extension, long currentFileSize, String name)
    {
        this.fileDetailsClass = new FileDetailsClass();
        this.fileDetailsClass.setFileURL(url);
        this.fileDetailsClass.setExtension(extension);
        this.fileDetailsClass.setCurrentFilesize(currentFileSize);
        this.fileDetailsClass.setFileHeaderName(name);
    }

    @Override
    public void createHTTPSConnection() throws Exception {
        new ResumeDownloadHTTPCon().setConnection(this.fileDetailsClass);
    }

    @Override
    public void createDownloadBar()
    {
        this.fileDetailsClass.setBar();
    }

    @Override
    public void createDownloadTask() throws IOException {
        fileDetailsClass.setTask(true);
    }

    @Override
    public void createDownloadThread()
    {
        this.fileDetailsClass.setThread();
    }

    public FileDetailsClass getFileDetailsClass() {
        return fileDetailsClass;
    }
}
