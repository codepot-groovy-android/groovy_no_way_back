package pl.codepot.groovy_no_way_back.factory;

import pl.codepot.groovy_no_way_back.dto.GitHubUser;

public final class GitHubUserFactory {

    public static GitHubUser newOrdonTeam() {
        GitHubUser ordonTeam = new GitHubUser();
        ordonTeam.login = "OrdonTeam";
        ordonTeam.id = 4918734L;
        ordonTeam.avatarUrl = "https://avatars.githubusercontent.com/u/4918734?v=3";
        ordonTeam.gravatarId = "";
        ordonTeam.url = "https://api.github.com/users/OrdonTeam";
        ordonTeam.htmlUrl = "https://github.com/OrdonTeam";
        ordonTeam.followersUrl = "https://api.github.com/users/OrdonTeam/followers";
        ordonTeam.followingUrl = "https://api.github.com/users/OrdonTeam/following{/other_user}";
        ordonTeam.gistsUrl = "https://api.github.com/users/OrdonTeam/gists{/gist_id}";
        ordonTeam.starredUrl = "https://api.github.com/users/OrdonTeam/starred{/owner}{/repo}";
        ordonTeam.subscriptionsUrl = "https://api.github.com/users/OrdonTeam/subscriptions";
        ordonTeam.organizationsUrl = "https://api.github.com/users/OrdonTeam/orgs";
        ordonTeam.reposUrl = "https://api.github.com/users/OrdonTeam/repos";
        ordonTeam.eventsUrl = "https://api.github.com/users/OrdonTeam/events{/privacy}";
        ordonTeam.receivedEventsUrl = "https://api.github.com/users/OrdonTeam/received_events";
        ordonTeam.type = "User";
        ordonTeam.siteAdmin = false;
        ordonTeam.name = "Karol";
        ordonTeam.company = null;
        ordonTeam.blog = null;
        ordonTeam.location = "Warsaw";
        ordonTeam.email = "ordon1313@gmail.com";
        ordonTeam.hireable = null;
        ordonTeam.bio = null;
        ordonTeam.publicRepos = 24;
        ordonTeam.publicGists = 0;
        ordonTeam.followers = 1;
        ordonTeam.following = 0;
        ordonTeam.createdAt = "2013-07-02T07:20:33Z";
        ordonTeam.updatedAt = "2015-08-08T18:43:17Z";
        return ordonTeam;
    }
}
