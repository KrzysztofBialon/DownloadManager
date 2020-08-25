package sample;

import java.net.URL;

public class FileDetailsClass
{
    private final String fileHeaderName;
    private final URL fileURL;
    private final Long fileSize;
    private final String extension;

    public FileDetailsClass(String fileHeaderName, URL fileURL, Long fileSize, String extension) {
        this.fileHeaderName = fileHeaderName;
        this.fileURL = fileURL;
        this.fileSize = fileSize;
        this.extension = extension;
    }

    public String getFileHeaderName() {
        return fileHeaderName;
    }

    public URL getFileURL() {
        return fileURL;
    }

    public long getFileSize() {
        return fileSize;
    }

    public String getExtension() {
        return extension;
    }
}
