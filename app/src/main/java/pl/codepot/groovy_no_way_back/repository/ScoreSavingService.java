package pl.codepot.groovy_no_way_back.repository;

public final class ScoreSavingService {

    BestScoreRepository bestScoreRepository;

    public ScoreSavingService(BestScoreRepository bestScoreRepository) {
        this.bestScoreRepository = bestScoreRepository;
    }

    public int getBestScore(){
        return bestScoreRepository.getBestScore();
    }

    public void saveBestScore(int currentScore){
        int bestScore = bestScoreRepository.getBestScore();
        bestScoreRepository.saveBestScore(Math.max(bestScore, currentScore));
    }
}
