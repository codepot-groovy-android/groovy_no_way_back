package pl.codepot.groovy_no_way_back.api.repo;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pl.codepot.groovy_no_way_back.MainActivity;
import pl.codepot.groovy_no_way_back.dagger.qualifier.GitHub;
import retrofit.RestAdapter;


@Module(
        complete = false,
        injects = MainActivity.class,
        library = true
)
@SuppressWarnings("unused")
public final class GitHubRepoModule {

    @Provides
    @Singleton
    GitHubRepoApi provideGitHubRepoApi(@GitHub RestAdapter restAdapter) {
        return restAdapter.create(GitHubRepoApi.class);
    }
}
