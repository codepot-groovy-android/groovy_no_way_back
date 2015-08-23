package pl.codepot.groovy_no_way_back.dagger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import dagger.ObjectGraph;

public final class Injector {

    private static ObjectGraph objectGraph;
    private static List<Object> testModules = new ArrayList<>();

    public static void inject(Object object) {
        if (objectGraph == null) {
            objectGraph = createObjectGraph();
        }
        objectGraph.inject(object);
    }

    public static void setTestModules(Object... modules) {
        testModules = Arrays.asList(modules);
        objectGraph = null;
    }

    private static ObjectGraph createObjectGraph() {
        List<Object> allModules = new ArrayList<>();
        allModules.add(new AppModule());
        allModules.addAll(testModules);
        return ObjectGraph.create(allModules.toArray());
    }
}
