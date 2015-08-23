package pl.codepot.groovy_no_way_back;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pl.codepot.groovy_no_way_back.api.user.GitHubUserApi;
import pl.codepot.groovy_no_way_back.dto.GitHubUser;
import retrofit.http.Path;
import rx.Observable;


@Module(
        complete = false,
        injects = MainActivity.class,
        library = true,
        overrides = true
)
@SuppressWarnings("unused")
public final class GitHubUserTestModule {

    @Provides
    @Singleton
    GitHubUserApi provideGitHubUserApi() {
        return new GitHubUserApi() {
            @Override
            public Observable<GitHubUser> get(@Path("username") String username) {
                GitHubUser ordonTeam = new GitHubUser();
                ordonTeam.login = "OrdonTeam";
                return Observable.just(ordonTeam);
            }
        };
    }
}
