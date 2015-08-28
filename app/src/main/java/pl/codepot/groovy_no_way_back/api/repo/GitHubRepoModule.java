package pl.codepot.groovy_no_way_back.api.repo;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pl.codepot.groovy_no_way_back.StartGameActivity;
import retrofit.RestAdapter;


@Module(
        complete = false,
        injects = StartGameActivity.class,
        library = true
)
@SuppressWarnings("unused")
public final class GitHubRepoModule {

    @Provides
    @Singleton
    GitHubUserReposApi provideGitHubUserReposApi(RestAdapter restAdapter) {
        return restAdapter.create(GitHubUserReposApi.class);
    }
}
