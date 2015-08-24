package pl.codepot.groovy_no_way_back.repository;

import android.content.SharedPreferences;

public final class BestScoreRepositoryImpl implements BestScoreRepository {

    private static final String BEST_SCORE_KEY = "best_score_key";

    private final SharedPreferences sharedPreferences;

    public BestScoreRepositoryImpl(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    @Override
    public int getBestScore() {
        return sharedPreferences.getInt(BEST_SCORE_KEY, 0);
    }

    @Override
    public void saveBestScore(int bestScore) {
        sharedPreferences.edit().putInt(BEST_SCORE_KEY, bestScore).apply();
    }
}
