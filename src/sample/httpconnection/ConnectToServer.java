package sample.httpconnection;

import sample.gui.elements.alert.AlertFactory;
import sample.logic.util.fileClass.FileDetailsClass;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;

public class ConnectToServer
{
    public static void connect(FileDetailsClass detailsClass, boolean isResume) throws IOException {
        //TODO rethink resuming
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) detailsClass.getFileURL().openConnection();
        if (isResume) httpsURLConnection.setRequestProperty("Range", "bytes="+(detailsClass.getCurrentFilesize())+"-");
        httpsURLConnection.setRequestMethod("GET");
        httpsURLConnection.connect();

        if(httpsURLConnection.getResponseCode() / 100 != 2)
        {
            AlertFactory.createAlert("CouldntConnectToServerAlert").showAndWait();
            return;
        }

        detailsClass.
                setFileHeaderName(
                        httpsURLConnection.
                                getHeaderField("Content-Disposition"));
        detailsClass.
                setFileSize(
                        httpsURLConnection.
                                getContentLengthLong());
    }
}
