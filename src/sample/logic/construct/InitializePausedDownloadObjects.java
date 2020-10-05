package sample.logic.construct;

import sample.logic.construct.FileclassConstructors.FileDetailsDirector;
import sample.logic.construct.factory.BuilderFactory;
import sample.logic.interfaces.IFileDetailsBuilder;
import sample.logic.util.fileClass.FileDetailsClass;
import sample.logic.util.fileClass.SplitStringToDetails;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class InitializePausedDownloadObjects
{
    public static List<FileDetailsClass> loadPausedFiles(List<String> pausedFilesDetailsList)
    {
        List<FileDetailsClass> pausedfiles = new ArrayList<>();

        pausedFilesDetailsList.forEach((file)->
                {
                    String name;
                    URL url;
                    String currentFilesize;
                    String totalFilesize;
                    SplitStringToDetails.extractDetails(file);
                    IFileDetailsBuilder fileDetailsBuilder = BuilderFactory.getBuilder(true);
                    FileDetailsDirector fileDetailsDirector = new FileDetailsDirector(fileDetailsBuilder);
                    fileDetailsDirector.constructFileDetails(url,);
                    pausedfiles.add()
                    //TODO
                });
    }
}
