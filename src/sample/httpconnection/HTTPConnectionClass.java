package sample.httpconnection;

import sample.FileDetailsClass;
import javax.net.ssl.HttpsURLConnection;

public class HTTPConnectionClass {
    public static void setConnection(FileDetailsClass detailsClass) throws Exception
    {
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) detailsClass.getFileURL().openConnection();
        httpsURLConnection.setRequestMethod("GET");
        httpsURLConnection.connect();
        if(httpsURLConnection.getResponseCode() / 100 != 2) return;

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
