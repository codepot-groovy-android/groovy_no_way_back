package pl.codepot.groovy_no_way_back.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pl.codepot.groovy_no_way_back.StartGameActivity;
import pl.codepot.groovy_no_way_back.api.user.GitHubUserApi;
import pl.codepot.groovy_no_way_back.api.user.GitHubUserSearchApi;
import pl.codepot.groovy_no_way_back.dto.GitHubSearchResults;
import pl.codepot.groovy_no_way_back.dto.GitHubUser;
import rx.Observable;


@Module(
        complete = false,
        injects = StartGameActivity.class,
        library = true,
        overrides = true
)
@SuppressWarnings("unused")
public final class FailingGitHubUserTestModule {

    @Provides
    @Singleton
    GitHubUserApi provideGitHubUserApi() {
        return new GitHubUserApi() {
            @Override
            public Observable<GitHubUser> get(String username) {
                return Observable.error(new RuntimeException());

            }
        };
    }

    @Provides
    @Singleton
    GitHubUserSearchApi provideGitHubUserSearchApi() {
        return new GitHubUserSearchApi() {
            @Override
            public Observable<GitHubSearchResults<GitHubUser>> get(String query) {
                return Observable.error(new RuntimeException());
            }
        };
    }
}
