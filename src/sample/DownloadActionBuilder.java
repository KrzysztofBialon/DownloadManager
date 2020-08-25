package sample;

import javafx.concurrent.Task;
import sample.gui.elements.DownloadItemBar;
import sample.httpconnection.HTTPConnectionClass;

public class DownloadActionBuilder
{
    private FileDetailsClass fileDetails;
    private DownloadPoolManager downloadPool;
    private DownloadItemBar bar;


    public Task build(String url, String ext) throws Exception {

        fileDetails = HTTPConnectionClass.setConnection(url, ext);
        downloadPool = new DownloadPoolManager();
        //bar = new DownloadItemBar(fileDetails.getFileHeaderName(), fileDetails.getFileSize());

        //downloadPool.addDownloadToPool(TaskBuilder.createSaveFileClass(fileDetails));
        return TaskBuilder.createSaveFileClass(fileDetails);
    }
}
