package pl.codepot.groovy_no_way_back.api.organization;

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
public final class GitHubOrganizationModule {

    @Provides
    @Singleton
    GitHubOrganizationApi provideGitHubOrganizationApi(@GitHub RestAdapter restAdapter) {
        return restAdapter.create(GitHubOrganizationApi.class);
    }

    @Provides
    @Singleton
    GitHubUserOrganizationsApi provideGitHubUserOrganizationsApi(@GitHub RestAdapter restAdapter){
        return restAdapter.create(GitHubUserOrganizationsApi.class);
    }
}
