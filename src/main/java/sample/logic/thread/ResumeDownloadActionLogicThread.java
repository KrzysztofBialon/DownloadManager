package sample.logic.thread;

import sample.logic.util.fileClass.FileDetailsClass;

public class ResumeDownloadActionLogicThread
{
    public static Runnable downloadActionThread(FileDetailsClass detailsClass)
    {
        Runnable runnable =() -> {
            Thread thread = detailsClass.getThread();
            thread.setDaemon(true);
            thread.start();
        };
        return runnable;
    }
}
