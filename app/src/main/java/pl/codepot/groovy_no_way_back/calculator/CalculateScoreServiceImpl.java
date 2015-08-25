package pl.codepot.groovy_no_way_back.calculator;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import pl.codepot.groovy_no_way_back.api.organization.GitHubOrganizationApi;
import pl.codepot.groovy_no_way_back.api.organization.GitHubUserOrganizationsApi;
import pl.codepot.groovy_no_way_back.api.repo.GitHubUserReposApi;
import pl.codepot.groovy_no_way_back.api.user.GitHubUserApi;
import pl.codepot.groovy_no_way_back.dto.GitHubOrganization;
import pl.codepot.groovy_no_way_back.dto.GitHubRepo;
import pl.codepot.groovy_no_way_back.dto.GitHubUser;
import rx.Observable;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.functions.FuncN;

public final class CalculateScoreServiceImpl implements CalculateScoreService {

    GitHubUserApi gitHubUserApi;
    GitHubUserReposApi gitHubUserReposApi;
    GitHubUserOrganizationsApi gitHubUserOrganizationsApi;
    private GitHubOrganizationApi gitHubOrganizationApi;

    public CalculateScoreServiceImpl(GitHubUserApi gitHubUserApi, GitHubUserReposApi gitHubUserReposApi, GitHubUserOrganizationsApi gitHubUserOrganizationsApi, GitHubOrganizationApi gitHubOrganizationApi) {
        this.gitHubUserApi = gitHubUserApi;
        this.gitHubUserReposApi = gitHubUserReposApi;
        this.gitHubUserOrganizationsApi = gitHubUserOrganizationsApi;
        this.gitHubOrganizationApi = gitHubOrganizationApi;
    }

    @Override
    public Observable<Integer> calculateScore(String username) {
        return userScore(username)
                .zipWith(allReposScore(username), sumFunction)
                .zipWith(allOrgsScore(username), sumFunction);
    }

    private Observable<Integer> allOrgsScore(String username) {
        return gitHubUserOrganizationsApi.get(username).map(new Func1<List<GitHubOrganization>, Integer>() {
            @Override
            public Integer call(List<GitHubOrganization> gitHubOrganizations) {
                return getOrganizationsAndSumUp(gitHubOrganizations);
            }
        });
    }

    private Integer getOrganizationsAndSumUp(List<GitHubOrganization> gitHubOrganizations) {
        List<Observable<GitHubOrganization>> organizationObservables = new ArrayList<>();
        for (GitHubOrganization organization : gitHubOrganizations) {
            organizationObservables.add(gitHubOrganizationApi.get(organization.login));
        }
        Observable.zip(organizationObservables, new FuncN<Integer>() {
            @Override
            public Integer call(Object... args) {
                return sumOrganizationsScore(args);
            }
        });
        return gitHubOrganizations.size();
    }

    private Integer sumOrganizationsScore(Object[] args) {
        int sum = 0;
        for (Object organization : Arrays.asList(args)) {
            GitHubOrganization gitHubOrganization = (GitHubOrganization) organization;
            sum += gitHubOrganization.public_repos + gitHubOrganization.followers;
        }
        return sum;
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

    Func2<Integer, Integer, Integer> sumFunction = new Func2<Integer, Integer, Integer>() {
        @Override
        public Integer call(Integer first, Integer second) {
            return first + second;
        }
    };
}
