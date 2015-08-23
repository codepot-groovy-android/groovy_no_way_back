package pl.codepot.groovy_no_way_back.dagger;

import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pl.codepot.groovy_no_way_back.api.user.GitHubUserModule;
import pl.codepot.groovy_no_way_back.dagger.qualifier.GitHub;
import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;


@Module(
        includes = GitHubUserModule.class,
        library = true
)
@SuppressWarnings("unused")
public final class AppModule {

    @Provides
    @Singleton
    @GitHub
    RestAdapter provideRestAdapter() {
        return new RestAdapter.Builder()
                .setEndpoint("https://api.github.com")
                .setConverter(new GsonConverter(new Gson()))
                .setClient(new OkClient())
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
    }
}
