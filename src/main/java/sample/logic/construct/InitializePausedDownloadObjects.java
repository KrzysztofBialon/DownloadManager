package sample.logic.construct;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import sample.logic.construct.FileclassConstructors.FileDetailsDirector;
import sample.logic.construct.factory.BuilderFactory;
import sample.logic.event.ResumeDownloadEvent;
import sample.logic.files.CheckExtension;
import sample.logic.files.CheckFileSize;
import sample.logic.files.CheckIfFileExists;
import sample.logic.interfaces.IFileDetailsBuilder;
import sample.logic.util.fileClass.FileDetailsClass;
import sample.logic.util.fileClass.SplitStringToDetails;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class InitializePausedDownloadObjects
{
    public static List<FileDetailsClass> loadPausedFiles(List<String> pausedFilesDetailsList, ExecutorService executorService, VBox wrapper)
    {
        List<FileDetailsClass> pausedfiles = new ArrayList<>();

        pausedFilesDetailsList.forEach((file)->
                {
                    String[] splittedDetails;
                    String name;
                    String extension;
                    URL url = null;
                    long currentFilesize = 0;
                    IFileDetailsBuilder fileDetailsBuilder;
                    FileDetailsDirector fileDetailsDirector;
                    FileDetailsClass fileDetailsClass;
                    //declarations

                    splittedDetails = SplitStringToDetails.extractDetails(file);
                    name = splittedDetails[0];

                    if(!CheckIfFileExists.exists(name)) { return;} //TODO alert ot exists
                    extension = CheckExtension.getExtension(name);

                    try {url = new URL(splittedDetails[1]);}
                    catch (MalformedURLException e) { e.printStackTrace(); }

                    try {currentFilesize = CheckFileSize.checkSize(name);}
                    catch (IOException e) { e.printStackTrace(); }

                    fileDetailsBuilder = BuilderFactory.getBuilder(true);
                    fileDetailsDirector = new FileDetailsDirector(fileDetailsBuilder);

                    try {
                        fileDetailsDirector.constructFileDetails(url,extension, currentFilesize);
                        fileDetailsClass =fileDetailsDirector.getFileDetailsClass();
                        pausedfiles.add(fileDetailsClass);
                        fileDetailsClass.
                                getBar().
                                getStartBtn().
                                addEventHandler(
                                        MouseEvent.MOUSE_CLICKED,
                                        new ResumeDownloadEvent(
                                                fileDetailsClass, executorService, wrapper));
                    } catch (IOException e) {e.printStackTrace();}

                    //TODO if catch exit creating object
                });
        return pausedfiles;
    }
}
