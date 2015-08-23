package pl.codepot.groovy_no_way_back;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.RestAdapter;


@Module(
        complete = false,
        injects = MainActivity.class,
        library = true
)
@SuppressWarnings("unused")
public final class GitHubUserModule {

    @Provides
    @Singleton
    GitHubUserApi provideGitHubUserApi(@GitHub RestAdapter restAdapter) {
        return restAdapter.create(GitHubUserApi.class);
    }
}
