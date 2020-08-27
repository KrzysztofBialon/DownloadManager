package sample;

public class FileDetailsDirector
{
    private FileDetailsBuilder fileDetailsBuilder;

    public FileDetailsDirector(FileDetailsBuilder fileDetailsBuilder) {
        this.fileDetailsBuilder = fileDetailsBuilder;
    }

    public void constructFileDetails() throws Exception {
        fileDetailsBuilder.createHTTPSConnection();
        fileDetailsBuilder.createDownloadBar();
        fileDetailsBuilder.createDownloadTask();
        fileDetailsBuilder.createDownloadThread();
    }

    public FileDetailsClass getFileDetailsClass()
    {
        return this.fileDetailsBuilder.getFileDetailsClass();
    }
}
