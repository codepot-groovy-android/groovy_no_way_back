package pl.codepot.groovy_no_way_back.calculator;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pl.codepot.groovy_no_way_back.CalculateScoreActivity;
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
    CalculateScoreService provideCalculateScoreService(GitHubUserApi gitHubUserApi) {
        return new CalculateScoreServiceImpl(gitHubUserApi);
    }
}
