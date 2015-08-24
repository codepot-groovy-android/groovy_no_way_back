package pl.codepot.groovy_no_way_back.calculator;

import rx.Observable;

public interface CalculateScoreService {
    Observable<Integer> calculateScore(String login);
}
