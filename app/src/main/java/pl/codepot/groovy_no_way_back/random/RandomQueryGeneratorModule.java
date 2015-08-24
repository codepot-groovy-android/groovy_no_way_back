package pl.codepot.groovy_no_way_back.random;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pl.codepot.groovy_no_way_back.ChooseUserActivity;

@Module(
        complete = false,
        injects = ChooseUserActivity.class,
        library = true
)
@SuppressWarnings("unused")
public final class RandomQueryGeneratorModule {

    @Provides
    @Singleton
    RandomQueryGenerator provideRandomQueryGenerator() {
        return new RandomQueryGenerator();
    }
}
