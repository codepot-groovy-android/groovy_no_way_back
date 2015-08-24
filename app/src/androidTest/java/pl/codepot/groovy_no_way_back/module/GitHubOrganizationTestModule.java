package pl.codepot.groovy_no_way_back.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pl.codepot.groovy_no_way_back.StartGameActivity;
import pl.codepot.groovy_no_way_back.api.organization.GitHubOrganizationApi;
import pl.codepot.groovy_no_way_back.dto.GitHubOrganization;
import pl.codepot.groovy_no_way_back.factory.GitHubOrganizationFactory;
import rx.Observable;


@Module(
        complete = false,
        injects = StartGameActivity.class,
        library = true,
        overrides = true
)
@SuppressWarnings("unused")
public final class GitHubOrganizationTestModule {

    @Provides
    @Singleton
    GitHubOrganizationApi provideGitHubUserApi() {
        return new GitHubOrganizationApi() {
            @Override
            public Observable<GitHubOrganization> get(String name) {
                return Observable.just(GitHubOrganizationFactory.newElPassion());
            }
        };
    }
}
