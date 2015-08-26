package pl.codepot.groovy_no_way_back.event;

import pl.codepot.groovy_no_way_back.dto.GitHubUser;

public final class UserChosenEvent {
    public final GitHubUser gitHubUser;

    public UserChosenEvent(GitHubUser gitHubUser) {
        this.gitHubUser = gitHubUser;
    }
}
