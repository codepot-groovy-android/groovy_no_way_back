package pl.codepot.groovy_no_way_back.module;

import java.util.Collections;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pl.codepot.groovy_no_way_back.StartGameActivity;
import pl.codepot.groovy_no_way_back.api.organization.GitHubOrganizationApi;
import pl.codepot.groovy_no_way_back.api.organization.GitHubUserOrganizationsApi;
import pl.codepot.groovy_no_way_back.dto.GitHubOrganization;
import pl.codepot.groovy_no_way_back.factory.GitHubOrganizationFactory;
import retrofit.http.Path;
import rx.Observable;

import static pl.codepot.groovy_no_way_back.factory.GitHubOrganizationFactory.newElPassion;


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
    GitHubOrganizationApi provideGitHubOrganizationApi() {
        return new GitHubOrganizationApi() {
            @Override
            public Observable<GitHubOrganization> get(String name) {
                return Observable.just(newElPassion());
            }
        };
    }

    @Provides
    @Singleton
    GitHubUserOrganizationsApi provideGitHubUserOrganizationsApi() {
        return new GitHubUserOrganizationsApi() {
            @Override
            public Observable<List<GitHubOrganization>> get(@Path("username") String username) {
                return Observable.just(Collections.singletonList(newElPassion()));
            }
        };
    }
}
