package pl.codepot.groovy_no_way_back.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pl.codepot.groovy_no_way_back.StartGameActivity;
import pl.codepot.groovy_no_way_back.repository.BestScoreRepository;

@Module(
        complete = false,
        injects = StartGameActivity.class,
        library = true,
        overrides = true
)
@SuppressWarnings("unused")
public final class BestScoreRepositoryTestModule {

    @Provides
    @Singleton
    BestScoreRepository provideBestScoreRepository() {
        return new BestScoreRepository() {
            @Override
            public int getBestScore() {
                return 16;
            }

            @Override
            public void saveBestScore(int bestScore) {

            }
        };
    }
}
