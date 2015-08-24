package pl.codepot.groovy_no_way_back.dagger;

import android.content.Context;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import dagger.ObjectGraph;

public final class Injector {

    private static ObjectGraph objectGraph;
    private static List<Object> testModules = new ArrayList<>();

    public static void inject(Context context, Object object) {
        if (objectGraph == null) {
            objectGraph = createObjectGraph(context);
        }
        objectGraph.inject(object);
    }

    public static void setTestModules(Object... modules) {
        testModules = Arrays.asList(modules);
        objectGraph = null;
    }

    private static ObjectGraph createObjectGraph(Context context) {
        List<Object> allModules = new ArrayList<>();
        allModules.add(new AppModule(context));
        allModules.addAll(testModules);
        return ObjectGraph.create(allModules.toArray());
    }
}
