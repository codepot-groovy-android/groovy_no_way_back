package pl.codepot.groovy_no_way_back.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pl.codepot.groovy_no_way_back.StartGameActivity;
import retrofit.RestAdapter;

@Module(
        library = true,
        overrides = true
)
@SuppressWarnings("unused")
public class RestAdapterNotAccessibleModule {

    @Provides
    @Singleton
    RestAdapter provideRestAdapter() {
        throw new RuntimeException("Cannot access network in tests.");
    }
}
