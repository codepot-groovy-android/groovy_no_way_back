package pl.codepot.groovy_no_way_back;

import org.junit.Assert;
import org.junit.Test;

import pl.codepot.groovy_no_way_back.random.RandomQueryGenerator;

public class RandomQueryGeneratorUnitTest {

    RandomQueryGenerator randomQueryGenerator = new RandomQueryGenerator();

    @Test
    public void testShouldReturnStringWith3Letter() throws Exception {
        String randomQuery = randomQueryGenerator.getRandomQuery();

        Assert.assertTrue(randomQuery.matches("[a-zA-Z]{2}"));
    }
}