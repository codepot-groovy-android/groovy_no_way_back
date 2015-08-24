package pl.codepot.groovy_no_way_back.api.user;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pl.codepot.groovy_no_way_back.ChooseUserActivity;
import pl.codepot.groovy_no_way_back.StartGameActivity;
import pl.codepot.groovy_no_way_back.dagger.qualifier.GitHub;
import retrofit.RestAdapter;


@Module(
        complete = false,
        injects = ChooseUserActivity.class,
        library = true
)
@SuppressWarnings("unused")
public final class GitHubUserModule {

    @Provides
    @Singleton
    GitHubUserApi provideGitHubUserApi(@GitHub RestAdapter restAdapter) {
        return restAdapter.create(GitHubUserApi.class);
    }

    @Provides
    @Singleton
    GitHubUserSearchApi provideGitHubUserSearchApi(@GitHub RestAdapter restAdapter) {
        return restAdapter.create(GitHubUserSearchApi.class);
    }
}
