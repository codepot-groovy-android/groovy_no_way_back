package pl.codepot.groovy_no_way_back;

import org.junit.Assert;
import org.junit.Test;

import pl.codepot.groovy_no_way_back.repository.BestScoreRepository;
import pl.codepot.groovy_no_way_back.repository.ScoreSavingService;

public class ScoreSavingServiceUnitTest {

    BestScoreRepositoryStub scoreRepositoryStub = new BestScoreRepositoryStub();

    @Test
    public void testScoreServiceShouldSaveBestScore() throws Exception {
        ScoreSavingService scoreSavingService = new ScoreSavingService(scoreRepositoryStub);
        scoreSavingService.saveBestScore(4);
        scoreSavingService.saveBestScore(8);

        Assert.assertEquals(8, scoreRepositoryStub.bestScore);
    }

    private static class BestScoreRepositoryStub implements BestScoreRepository {

        private int bestScore = 0;

        @Override
        public int getBestScore() {
            return bestScore;
        }

        @Override
        public void saveBestScore(int bestScore) {
            this.bestScore = bestScore;
        }
    }
}