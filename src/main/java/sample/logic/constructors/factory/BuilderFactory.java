package sample.logic.constructors.factory;

import sample.logic.constructors.builder.NewFileDetailsBuilder;
import sample.logic.constructors.builder.ResumeFileDetailsBuilder;
import sample.logic.interfaces.IFileDetailsBuilder;

public class BuilderFactory
{
    public static IFileDetailsBuilder getBuilder(boolean isResume)
    {
        return isResume ? new ResumeFileDetailsBuilder() : new NewFileDetailsBuilder();
    }
}
