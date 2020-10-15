package sample.httpconnection;

import sample.logic.constructors.factory.AlertFactory;
import sample.logic.interfaces.IHTTPConnection;
import sample.logic.util.fileClass.FileDetailsClass;
import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;

public class NewHTTPConnectionClass implements IHTTPConnection {
    
    @Override
    public void setConnection(FileDetailsClass detailsClass) throws IOException
    { //set connection for new download
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) detailsClass.getFileURL().openConnection();
        httpsURLConnection.setConnectTimeout(5000);
        httpsURLConnection.setRequestMethod("GET");
        httpsURLConnection.connect();

        if(httpsURLConnection.getResponseCode() / 100 != 2)
        {
            AlertFactory.createAlert("CouldntConnectToServerAlert").showAndWait();
            return;
        }
        //ask server for filename and set
        detailsClass.
                setFileHeaderName(
                        httpsURLConnection.
                                getHeaderField("Content-Disposition"));
        //ask server for filesize and set
        detailsClass.
                setFileSize(
                        httpsURLConnection.
                                getContentLengthLong());
    }
}
