package pl.codepot.groovy_no_way_back.calculator;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import pl.codepot.groovy_no_way_back.api.organization.GitHubOrganizationApi;
import pl.codepot.groovy_no_way_back.api.organization.GitHubUserOrganizationsApi;
import pl.codepot.groovy_no_way_back.api.repo.GitHubUserReposApi;
import pl.codepot.groovy_no_way_back.api.user.GitHubUserApi;
import pl.codepot.groovy_no_way_back.dto.GitHubOrganization;
import pl.codepot.groovy_no_way_back.dto.GitHubRepo;
import pl.codepot.groovy_no_way_back.dto.GitHubUser;
import rx.Observable;
import rx.functions.Func1;
import rx.functions.Func3;
import rx.functions.FuncN;

import static rx.Observable.zip;

public final class CalculateScoreService {

    private GitHubUserApi gitHubUserApi;
    private GitHubUserReposApi gitHubUserReposApi;
    private GitHubUserOrganizationsApi gitHubUserOrganizationsApi;
    private GitHubOrganizationApi gitHubOrganizationApi;

    @Inject
    public CalculateScoreService(GitHubUserApi gitHubUserApi, GitHubUserReposApi gitHubUserReposApi, GitHubUserOrganizationsApi gitHubUserOrganizationsApi, GitHubOrganizationApi gitHubOrganizationApi) {
        this.gitHubUserApi = gitHubUserApi;
        this.gitHubUserReposApi = gitHubUserReposApi;
        this.gitHubUserOrganizationsApi = gitHubUserOrganizationsApi;
        this.gitHubOrganizationApi = gitHubOrganizationApi;
    }

    public Observable<Integer> calculateScore(String username) {
        return zip(userScore(username), allReposScore(username), allOrgsScore(username), sumFunction);
    }

    private Observable<Integer> allOrgsScore(String username) {
        return gitHubUserOrganizationsApi.get(username).flatMap(new Func1<List<GitHubOrganization>, Observable<Integer>>() {
            @Override
            public Observable<Integer> call(List<GitHubOrganization> gitHubOrganizations) {
                return getOrganizationsAndSumUp(gitHubOrganizations);
            }
        });
    }

    private Observable<Integer> getOrganizationsAndSumUp(List<GitHubOrganization> gitHubOrganizations) {
        if (gitHubOrganizations.isEmpty()) {
            return Observable.just(0);
        }
        List<Observable<GitHubOrganization>> organizationObservables = new ArrayList<>();
        for (GitHubOrganization organization : gitHubOrganizations) {
            organizationObservables.add(gitHubOrganizationApi.get(organization.login));
        }
        return zip(organizationObservables, new FuncN<Integer>() {
            @Override
            public Integer call(Object... args) {
                return sumOrganizationsScore(args);
            }
        });
    }

    private Integer sumOrganizationsScore(Object... args) {
        int sum = 0;
        for (Object organization : args) {
            GitHubOrganization gitHubOrganization = (GitHubOrganization) organization;
            sum += gitHubOrganization.publicRepos;
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
            sum += gitHubRepo.getStargazersCount() + gitHubRepo.getForksCount() + gitHubRepo.getWatchersCount();
        }
        return sum;
    }

    Func3<Integer, Integer, Integer, Integer> sumFunction = new Func3<Integer, Integer, Integer, Integer>() {
        @Override
        public Integer call(Integer first, Integer second, Integer third) {
            return first + second + third;
        }
    };
}
