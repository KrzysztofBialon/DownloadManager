package sample;

import sample.gui.elements.DownloadItemBar;
import sample.httpconnection.HTTPConnectionClass;

public class DownloadActionBuilder
{
    private FileDetailsClass fileDetails;
    private DownloadPoolManager downloadPool;
    private DownloadItemBar bar;

    /*public  DownloadActionBuilder fileDetails(String url, String ext) throws Exception
    {
        this.fileDetails = HTTPConnectionClass.setConnection(url, ext);
        return this;
    }

    public DownloadActionBuilder downloadPool()
    {
        this.downloadPool = new DownloadPoolManager();
        return this;
    }

    public DownloadActionBuilder downloadBar()
    {
        this.bar = new DownloadItemBar(this.fileDetails.getFileHeaderName(), this.fileDetails.getFileSize());
        return this;
    }*/

    public void build(String url, String ext) throws Exception {

        fileDetails = HTTPConnectionClass.setConnection(url, ext);
        downloadPool = new DownloadPoolManager();
        bar = new DownloadItemBar(fileDetails.getFileHeaderName(), fileDetails.getFileSize());

        downloadPool.addDownloadToPool(TaskBuilder.createSaveFileClass(fileDetails), bar);
    }

    public DownloadItemBar getBar()
    {
        return this.bar;
    }
}
