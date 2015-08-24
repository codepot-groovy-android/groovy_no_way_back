package pl.codepot.groovy_no_way_back.repository;

public interface BestScoreRepository {

    int getBestScore();

    void saveBestScore(int bestScore);
}
