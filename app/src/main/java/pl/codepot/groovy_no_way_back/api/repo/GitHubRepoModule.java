package pl.codepot.groovy_no_way_back.api.repo;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pl.codepot.groovy_no_way_back.StartGameActivity;
import pl.codepot.groovy_no_way_back.dagger.qualifier.GitHub;
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
    GitHubRepoApi provideGitHubRepoApi(@GitHub RestAdapter restAdapter) {
        return restAdapter.create(GitHubRepoApi.class);
    }

    @Provides
    @Singleton
    GitHubRepoSearchApi provideGitHubRepoSearchApi(@GitHub RestAdapter restAdapter) {
        return restAdapter.create(GitHubRepoSearchApi.class);
    }

    @Provides
    @Singleton
    GitHubUserReposApi provideGitHubUserReposApi(@GitHub RestAdapter restAdapter) {
        return restAdapter.create(GitHubUserReposApi.class);
    }
}
