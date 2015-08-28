package pl.codepot.groovy_no_way_back.module;

import java.util.Collections;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pl.codepot.groovy_no_way_back.StartGameActivity;
import pl.codepot.groovy_no_way_back.api.repo.GitHubUserReposApi;
import pl.codepot.groovy_no_way_back.dto.GitHubRepo;
import rx.Observable;

import static java.util.Collections.singletonList;
import static pl.codepot.groovy_no_way_back.factory.GitHubRepoFactory.newAndroidMaze;
import static rx.Observable.just;


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
    GitHubUserReposApi provideGitHubUserReposApi() {
        return new GitHubUserReposApi() {
            @Override
            public Observable<List<GitHubRepo>> get(String username) {
                return just(singletonList(newAndroidMaze()));
            }
        };
    }
}
