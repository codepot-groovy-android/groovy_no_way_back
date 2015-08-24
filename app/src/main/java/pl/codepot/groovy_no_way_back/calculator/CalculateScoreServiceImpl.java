package pl.codepot.groovy_no_way_back.calculator;

import rx.Observable;

public final class CalculateScoreServiceImpl implements CalculateScoreService {
    @Override
    public Observable<Integer> calculateScore() {
        return Observable.just(0);
    }
}
