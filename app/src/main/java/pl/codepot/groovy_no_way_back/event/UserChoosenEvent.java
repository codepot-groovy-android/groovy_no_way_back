package pl.codepot.groovy_no_way_back.event;

import pl.codepot.groovy_no_way_back.dto.GitHubUser;

public final class UserChoosenEvent {
    public final GitHubUser gitHubUser;

    public UserChoosenEvent(GitHubUser gitHubUser) {
        this.gitHubUser = gitHubUser;
    }
}
