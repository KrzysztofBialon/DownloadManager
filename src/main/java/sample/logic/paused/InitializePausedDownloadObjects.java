package sample.logic.paused;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import sample.logic.constructors.director.FileDetailsDirector;
import sample.logic.constructors.factory.BuilderFactory;
import sample.logic.event.ResumeDownloadEvent;
import sample.logic.files.check.CheckExtension;
import sample.logic.files.check.CheckFileSize;
import sample.logic.files.check.CheckIfFileExists;
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
                    FileDetailsClass fileDetailsClass; //variable declarations
                    //get string, split into fragments, build detailsClass from it and return as DetailsClass collection
                    splittedDetails = SplitStringToDetails.extractDetails(file);
                    name = splittedDetails[0];

                    if(!CheckIfFileExists.exists(name)) { return;}
                    extension = CheckExtension.getExtension(name);

                    try {url = new URL(splittedDetails[1]);}
                    catch (MalformedURLException e) { e.printStackTrace(); }

                    try {currentFilesize = CheckFileSize.checkSize(name);}
                    catch (IOException e) { e.printStackTrace(); }

                    fileDetailsBuilder = BuilderFactory.getBuilder(true);
                    fileDetailsDirector = new FileDetailsDirector(fileDetailsBuilder);

                    try {
                        fileDetailsDirector.constructFileDetails(url,extension, currentFilesize, name);
                        fileDetailsClass = fileDetailsDirector.getFileDetailsClass();

                        pausedfiles.add(fileDetailsClass);
                        //adds resume event handler to button
                        fileDetailsClass.
                                getBar().
                                getStartBtn().
                                addEventHandler(
                                        MouseEvent.MOUSE_CLICKED,
                                        new ResumeDownloadEvent(
                                                fileDetailsClass, executorService, wrapper));
                    } catch (IOException e) {e.printStackTrace();}
                });
        return pausedfiles;
    }
}
