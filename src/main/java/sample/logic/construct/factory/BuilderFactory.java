package sample.logic.construct.factory;

import sample.logic.construct.FileclassConstructors.NewFileDetailsBuilder;
import sample.logic.construct.FileclassConstructors.ResumeFileDetailsBuilder;
import sample.logic.interfaces.IFileDetailsBuilder;

public class BuilderFactory
{
    public static IFileDetailsBuilder getBuilder(boolean isResume)
    {
        return isResume ? new ResumeFileDetailsBuilder() : new NewFileDetailsBuilder();
    }
}
