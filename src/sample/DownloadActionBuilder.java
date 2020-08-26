package sample;

import javafx.concurrent.Task;
import sample.download.SaveFileFromURL;
import sample.gui.elements.DownloadItemBar;
import sample.httpconnection.HTTPConnectionClass;

public class DownloadActionBuilder
{
    public Task build(FileDetailsClass fileDetails) {
        return SaveFileFromURL.setDestination(fileDetails);
    }
}
