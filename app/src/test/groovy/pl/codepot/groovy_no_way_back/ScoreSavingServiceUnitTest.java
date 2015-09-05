package pl.codepot.groovy_no_way_back;

import org.junit.Assert;
import org.junit.Test;

import pl.codepot.groovy_no_way_back.repository.BestScoreRepository;
import pl.codepot.groovy_no_way_back.repository.ScoreSavingService;

public class ScoreSavingServiceUnitTest {

    BestScoreRepositorySpy repositorySpy = new BestScoreRepositorySpy();
    ScoreSavingService scoreSavingService = new ScoreSavingService(repositorySpy);

    @Test
    public void testScoreServiceShouldSaveBestScore() throws Exception {
        scoreSavingService.saveBestScore(4);
        scoreSavingService.saveBestScore(8);

        Assert.assertEquals(8, repositorySpy.bestScore);
    }

    @Test
    public void testScoreServiceShouldNotOverrideBestScoreWithSmallerValue() throws Exception {
        scoreSavingService.saveBestScore(3);
        scoreSavingService.saveBestScore(1);

        Assert.assertEquals(3, repositorySpy.bestScore);
    }

    private static class BestScoreRepositorySpy implements BestScoreRepository {

        private int bestScore = -1;

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