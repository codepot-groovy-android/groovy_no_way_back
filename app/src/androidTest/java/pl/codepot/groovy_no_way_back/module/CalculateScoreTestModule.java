package pl.codepot.groovy_no_way_back.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pl.codepot.groovy_no_way_back.StartGameActivity;
import pl.codepot.groovy_no_way_back.calculator.CalculateScoreService;
import pl.codepot.groovy_no_way_back.repository.BestScoreRepository;
import rx.Observable;

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
            public Observable<Integer> calculateScore() {
                return Observable.just(25);
            }
        };
    }
}
