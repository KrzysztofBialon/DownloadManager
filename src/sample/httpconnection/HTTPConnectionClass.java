package sample.httpconnection;

import sample.download.SaveFileFromURL;
import sample.gui.DownloadItemBar;

import javax.net.ssl.HttpsURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HTTPConnectionClass {

    private URL url;

    public HTTPConnectionClass(String url) throws MalformedURLException {
        this.url = new URL(url);
    }

    public int setConnection() throws Exception
    {
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
        httpsURLConnection.setRequestMethod("GET");
        httpsURLConnection.connect();

        return httpsURLConnection.getResponseCode();

    }
}
