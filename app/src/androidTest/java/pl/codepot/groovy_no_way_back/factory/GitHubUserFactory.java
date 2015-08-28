package pl.codepot.groovy_no_way_back.factory;

import pl.codepot.groovy_no_way_back.dto.GitHubUser;

public final class GitHubUserFactory {

    public static GitHubUser newOrdonTeam() {
        GitHubUser ordonTeam = new GitHubUser();
        ordonTeam.login = "OrdonTeam";
        ordonTeam.id = 4918734L;
        ordonTeam.avatarUrl = "https://avatars.githubusercontent.com/u/4918734?v=3";
        ordonTeam.name = "Karol";
        ordonTeam.followers = 1;
        return ordonTeam;
    }
}
