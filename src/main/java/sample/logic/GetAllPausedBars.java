package sample.logic;

import javafx.scene.Node;
import sample.logic.util.fileClass.FileDetailsClass;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GetAllPausedBars
{
    public static Collection<Node> getBars(List<FileDetailsClass> filesList)
    {
        Collection<Node> bars = new ArrayList<>();
        filesList.forEach((file) ->
        {
            bars.add(file.getBar().getWrapper());
        });
        return bars;
    }
}
