package pl.codepot.groovy_no_way_back;

import com.google.gson.Gson;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;


@Module(
        injects = MainActivity.class,
        library = true
)
@SuppressWarnings("unused")
public final class GitHubUserModule {

    @Provides
    @Singleton
    GitHubUserApi provideGitHubUserApi() {
        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint("https://api.github.com")
                .setConverter(new GsonConverter(new Gson())).setClient(new OkClient()).setLogLevel(RestAdapter.LogLevel.FULL).build();
        return restAdapter.create(GitHubUserApi.class);
    }
}
