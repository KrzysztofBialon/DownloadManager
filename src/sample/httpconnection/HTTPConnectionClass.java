package sample.httpconnection;

import sample.FileDetailsClass;
import sample.download.SaveFileFromURL;
import sample.gui.DownloadItemBar;

import javax.net.ssl.HttpsURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HTTPConnectionClass {

    /*private URL url;
    private String extension;

    public HTTPConnectionClass(String url, String ext) throws MalformedURLException {
        this.url = new URL(url);
        this.extension = ext;
    }*/

    public static FileDetailsClass setConnection(String url, String extension) throws Exception
    {
        URL urlBuilder = new URL(url);
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) urlBuilder.openConnection();
        httpsURLConnection.setRequestMethod("GET");
        httpsURLConnection.connect();
        if(httpsURLConnection.getResponseCode() != 200) return null;
        return new FileDetailsClass(httpsURLConnection.getHeaderField(
                "Content-Disposition"), urlBuilder, httpsURLConnection.getContentLengthLong(), extension);
    }
}
