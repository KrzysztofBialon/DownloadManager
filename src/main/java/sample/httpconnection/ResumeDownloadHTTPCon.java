package sample.httpconnection;

import sample.gui.elements.alert.AlertFactory;
import sample.logic.interfaces.IHTTPConnection;
import sample.logic.util.fileClass.FileDetailsClass;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;

public class ResumeDownloadHTTPCon implements IHTTPConnection
{
    @Override
    public void setConnection(FileDetailsClass detailsClass) throws IOException
    {
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) detailsClass.getFileURL().openConnection();
        httpsURLConnection.setConnectTimeout(5000);
        httpsURLConnection.setRequestProperty("Range", "bytes="+(detailsClass.getCurrentFilesize())+"-");
        httpsURLConnection.setRequestMethod("GET");
        httpsURLConnection.connect();

        if(httpsURLConnection.getResponseCode() / 100 != 2)
        {
            AlertFactory.createAlert("CouldntConnectToServerAlert").showAndWait();
            return;
        }
//TODO delete canceled files from txt
        detailsClass.
                setFileSize(
                        httpsURLConnection.
                                getContentLengthLong());
    }
}
