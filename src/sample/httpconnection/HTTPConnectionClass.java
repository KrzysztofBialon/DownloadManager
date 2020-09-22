package sample.httpconnection;

import sample.gui.elements.alert.AlertFactory;
import sample.gui.elements.alert.CouldntConnectToServerAlert;
import sample.logic.util.fileClass.FileDetailsClass;
import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;

public class HTTPConnectionClass {
    public static void setConnection(FileDetailsClass detailsClass) throws IOException {

        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) detailsClass.getFileURL().openConnection();
        httpsURLConnection.setRequestMethod("GET");
        httpsURLConnection.connect();

        if(httpsURLConnection.getResponseCode() / 100 != 2)
        {
            System.out.println("niemoznapol");
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
