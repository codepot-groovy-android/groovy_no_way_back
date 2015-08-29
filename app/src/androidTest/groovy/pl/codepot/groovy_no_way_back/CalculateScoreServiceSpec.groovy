package pl.codepot.groovy_no_way_back

import pl.codepot.groovy_no_way_back.api.organization.GitHubOrganizationApi
import pl.codepot.groovy_no_way_back.api.organization.GitHubUserOrganizationsApi
import pl.codepot.groovy_no_way_back.api.repo.GitHubUserReposApi
import pl.codepot.groovy_no_way_back.api.user.GitHubUserApi
import pl.codepot.groovy_no_way_back.calculator.CalculateScoreService
import spock.lang.Specification
import spock.lang.Unroll

import static pl.codepot.groovy_no_way_back.factory.GitHubUserFactory.newUserWithFollowers
import static rx.Observable.just;

final class CalculateScoreServiceSpec extends Specification {

    GitHubUserApi gitHubUserApi = Mock(GitHubUserApi)
    GitHubUserReposApi gitHubUserReposApi = Mock(GitHubUserReposApi)
    GitHubUserOrganizationsApi gitHubUserOrganizationsApi = Mock(GitHubUserOrganizationsApi)
    GitHubOrganizationApi gitHubOrganizationApi = Mock(GitHubOrganizationApi)

    @Unroll
    def "Should calculate score exuals to #followers"() {
        given:
        CalculateScoreService service = new CalculateScoreService(gitHubUserApi, gitHubUserReposApi, gitHubUserOrganizationsApi, gitHubOrganizationApi)
        gitHubUserApi.get(_) >> just(newUserWithFollowers(followers))
        gitHubUserReposApi.get(_) >> just([])
        gitHubUserOrganizationsApi.get(_) >> just([])
        when:
        int score = 7
        service.calculateScore('any username').subscribe {
            score = it
        }
        then:
        score == followers
        where:
        followers << (0..<100)
    }

}
