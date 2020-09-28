package sample.httpconnection;

import sample.logic.CheckFileSize;
import sample.logic.interfaces.IHTTPConnection;
import sample.logic.util.fileClass.FileDetailsClass;
import java.io.IOException;

public class ResumeDownloadHTTPCon implements IHTTPConnection
{
    long fileSize = 0;
    @Override
    public void setConnection(FileDetailsClass detailsClass) throws IOException
    {//TODO resume con
        fileSize = CheckFileSize.checkSize(detailsClass.getFileHeaderName());
        detailsClass.setCurrentFilesize(fileSize);
        if(fileSize == 0)
        {
            //TODO alert no exists
            return;
        }
        ConnectToServer.connect(detailsClass, true);
    }
}
