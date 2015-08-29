package pl.codepot.groovy_no_way_back.api.user;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pl.codepot.groovy_no_way_back.ChooseUserActivity;
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
    GitHubUserApi provideGitHubUserApi(RestAdapter restAdapter) {
        return restAdapter.create(GitHubUserApi.class);
    }

    @Provides
    @Singleton
    GitHubUserSearchApi provideGitHubUserSearchApi(RestAdapter restAdapter) {
        return restAdapter.create(GitHubUserSearchApi.class);
    }
}
