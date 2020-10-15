package sample.logic.util.fileClass;

public class SplitStringToDetails
{
    public static String[] extractDetails(String line)
    { //splits line from pausedfiles.txt into needed fragments
        String[] splittedLine = line.split(" ", 0);
        return  splittedLine;
    }
}
