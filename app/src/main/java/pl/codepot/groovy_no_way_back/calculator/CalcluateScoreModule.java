package pl.codepot.groovy_no_way_back.calculator;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pl.codepot.groovy_no_way_back.CalculateScoreActivity;
import pl.codepot.groovy_no_way_back.api.organization.GitHubOrganizationApi;
import pl.codepot.groovy_no_way_back.api.organization.GitHubUserOrganizationsApi;
import pl.codepot.groovy_no_way_back.api.repo.GitHubUserReposApi;
import pl.codepot.groovy_no_way_back.api.user.GitHubUserApi;

@Module(
        complete = false,
        injects = CalculateScoreActivity.class,
        library = true
)
@SuppressWarnings("unused")
public final class CalcluateScoreModule {

    @Provides
    @Singleton
    CalculateScoreService provideCalculateScoreService(GitHubUserApi gitHubUserApi, GitHubUserReposApi gitHubUserReposApi, GitHubUserOrganizationsApi gitHubUserOrganizationsApi, GitHubOrganizationApi gitHubOrganizationApi) {
        return new CalculateScoreServiceImpl(gitHubUserApi, gitHubUserReposApi, gitHubUserOrganizationsApi,gitHubOrganizationApi);
    }
}
