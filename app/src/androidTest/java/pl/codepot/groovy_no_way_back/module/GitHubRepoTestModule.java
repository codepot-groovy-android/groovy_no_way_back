package pl.codepot.groovy_no_way_back.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pl.codepot.groovy_no_way_back.StartGameActivity;
import pl.codepot.groovy_no_way_back.api.repo.GitHubRepoApi;
import pl.codepot.groovy_no_way_back.api.repo.GitHubRepoSearchApi;
import pl.codepot.groovy_no_way_back.dto.GitHubRepo;
import pl.codepot.groovy_no_way_back.dto.GitHubSearchResults;
import rx.Observable;

import static pl.codepot.groovy_no_way_back.factory.GitHubRepoFactory.newAndroidMaze;


@Module(
        complete = false,
        injects = StartGameActivity.class,
        library = true,
        overrides = true
)
@SuppressWarnings("unused")
public final class GitHubRepoTestModule {

    @Provides
    @Singleton
    GitHubRepoApi provideGitHubRepoApi() {
        return new GitHubRepoApi() {
            @Override
            public Observable<GitHubRepo> get(String username, String reponame) {
                return Observable.just(newAndroidMaze());
            }
        };
    }

    @Provides
    @Singleton
    GitHubRepoSearchApi provideGitHubRepoSearchApi() {
        return new GitHubRepoSearchApi() {
            @Override
            public Observable<GitHubSearchResults<GitHubRepo>> get(String query) {
                return Observable.just(new GitHubSearchResults<>(newAndroidMaze()));
            }
        };
    }
}
