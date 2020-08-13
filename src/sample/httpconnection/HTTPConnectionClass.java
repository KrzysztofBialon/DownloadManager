package sample.httpconnection;

import sample.download.SaveFileFromURL;

import javax.net.ssl.HttpsURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HTTPConnectionClass {

    private URL url;
    private String fileExtension;

    public HTTPConnectionClass(String url,  String fileExtension) throws MalformedURLException {
        this.url = new URL(url);
    }

    public void setConnection() throws Exception
    {
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
        httpsURLConnection.setRequestMethod("GET");
        httpsURLConnection.connect();

        new SaveFileFromURL(url, fileExtension).run();

    }
}
