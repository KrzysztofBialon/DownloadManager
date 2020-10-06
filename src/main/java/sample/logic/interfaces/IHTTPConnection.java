package sample.logic.interfaces;

import sample.logic.util.fileClass.FileDetailsClass;

import java.io.IOException;

public interface IHTTPConnection
{
    void setConnection(FileDetailsClass detailsClass) throws IOException;
}
