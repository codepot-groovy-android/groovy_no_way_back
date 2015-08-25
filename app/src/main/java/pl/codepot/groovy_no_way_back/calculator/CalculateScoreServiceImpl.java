package pl.codepot.groovy_no_way_back.calculator;

import java.util.List;

import pl.codepot.groovy_no_way_back.api.repo.GitHubUserReposApi;
import pl.codepot.groovy_no_way_back.api.user.GitHubUserApi;
import pl.codepot.groovy_no_way_back.dto.GitHubRepo;
import pl.codepot.groovy_no_way_back.dto.GitHubUser;
import rx.Observable;
import rx.functions.Func1;
import rx.functions.Func2;

public final class CalculateScoreServiceImpl implements CalculateScoreService {

    GitHubUserApi gitHubUserApi;
    GitHubUserReposApi gitHubUserReposApi;

    public CalculateScoreServiceImpl(GitHubUserApi gitHubUserApi, GitHubUserReposApi gitHubUserReposApi) {
        this.gitHubUserApi = gitHubUserApi;
        this.gitHubUserReposApi = gitHubUserReposApi;
    }

    @Override
    public Observable<Integer> calculateScore(String username) {
        return userScore(username).zipWith(allReposScore(username), new Func2<Integer, Integer, Integer>() {
            @Override
            public Integer call(Integer reposScore, Integer userScore) {
                return reposScore + userScore;
            }
        });
    }

    private Observable<Integer> userScore(String username) {
        return gitHubUserApi.get(username)
                .map(new Func1<GitHubUser, Integer>() {
                    @Override
                    public Integer call(GitHubUser gitHubUser) {
                        return gitHubUser.followers;
                    }
                });
    }

    private Observable<Integer> allReposScore(String username) {
        return gitHubUserReposApi.get(username)
                .map(new Func1<List<GitHubRepo>, Integer>() {
                    @Override
                    public Integer call(List<GitHubRepo> gitHubRepos) {
                        return sumReposScore(gitHubRepos);
                    }
                });
    }

    private Integer sumReposScore(List<GitHubRepo> gitHubRepos) {
        int sum = 0;
        for (GitHubRepo gitHubRepo : gitHubRepos) {
            sum += gitHubRepo.stargazersCount + gitHubRepo.forksCount + gitHubRepo.watchersCount;
        }
        return sum;
    }
}
