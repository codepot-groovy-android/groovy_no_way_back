package pl.codepot.groovy_no_way_back;

import dagger.ObjectGraph;

public final class Injector {

    private static ObjectGraph objectGraph;

    public static void inject(Object object) {
        if (objectGraph == null) {
            objectGraph = ObjectGraph.create(new AppModule());
        }
        objectGraph.inject(object);
    }

}
