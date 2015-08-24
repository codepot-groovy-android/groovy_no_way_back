package pl.codepot.groovy_no_way_back.calculator;

import pl.codepot.groovy_no_way_back.api.user.GitHubUserApi;
import pl.codepot.groovy_no_way_back.dto.GitHubUser;
import rx.Observable;
import rx.functions.Func1;

public final class CalculateScoreServiceImpl implements CalculateScoreService {

    GitHubUserApi gitHubUserApi;

    public CalculateScoreServiceImpl(GitHubUserApi gitHubUserApi) {
        this.gitHubUserApi = gitHubUserApi;
    }

    @Override
    public Observable<Integer> calculateScore(String username) {
        return gitHubUserApi.get(username).map(new Func1<GitHubUser, Integer>() {
            @Override
            public Integer call(GitHubUser gitHubUser) {
                return gitHubUser.followers;
            }
        });
    }
}
