package pl.codepot.groovy_no_way_back.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pl.codepot.groovy_no_way_back.StartGameActivity;
import pl.codepot.groovy_no_way_back.calculator.CalculateScoreService;
import rx.Observable;

import static rx.Observable.just;

@Module(
        complete = false,
        injects = StartGameActivity.class,
        library = true,
        overrides = true
)
@SuppressWarnings("unused")
public final class CalculateScoreTestModule {

    @Provides
    @Singleton
    CalculateScoreService provideBestScoreRepository() {
        return new CalculateScoreService() {
            @Override
            public Observable<Integer> calculateScore(String login) {
                return just(25);
            }
        };
    }
}
