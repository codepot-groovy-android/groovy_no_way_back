package pl.codepot.groovy_no_way_back.repository;

import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pl.codepot.groovy_no_way_back.StartGameActivity;

@Module(
        complete = false,
        injects = StartGameActivity.class,
        library = true
)
@SuppressWarnings("unused")
public final class ScoreModule {

    @Provides
    @Singleton
    ScoreSavingService provideScoreSavingService(BestScoreRepository bestScoreRepository) {
        return new ScoreSavingService(bestScoreRepository);
    }

    @Provides
    @Singleton
    BestScoreRepository provideBestScoreRepository(SharedPreferences sharedPreferences) {
        return new BestScoreRepositoryImpl(sharedPreferences);
    }
}
