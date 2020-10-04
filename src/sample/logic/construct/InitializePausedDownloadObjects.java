package sample.logic.construct;

import sample.logic.util.fileClass.FileDetailsClass;
import sample.logic.util.fileClass.SplitStringToDetails;

import java.util.ArrayList;
import java.util.List;

public class InitializePausedDownloadObjects
{
    public static List<FileDetailsClass> loadPausedFiles(List<String> pausedFilesDetailsList)
    {
        List<FileDetailsClass> pausedfiles = new ArrayList<>();

        pausedFilesDetailsList.forEach((file)->
                {
                    SplitStringToDetails.extractDetails(file);
                    //TODO
                });
    }
}
