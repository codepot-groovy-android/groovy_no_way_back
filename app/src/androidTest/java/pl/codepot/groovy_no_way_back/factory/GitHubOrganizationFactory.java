package pl.codepot.groovy_no_way_back.factory;

import pl.codepot.groovy_no_way_back.dto.GitHubOrganization;

public final class GitHubOrganizationFactory {

    public static GitHubOrganization newElPassion() {
        GitHubOrganization elPassion = new GitHubOrganization();
        elPassion.login = "elpassion";
        elPassion.id = 98255L;
        elPassion.url = "https://api.github.com/orgs/elpassion";
        elPassion.repos_url = "https://api.github.com/orgs/elpassion/repos";
        elPassion.events_url = "https://api.github.com/orgs/elpassion/events";
        elPassion.members_url = "https://api.github.com/orgs/elpassion/members{/member}";
        elPassion.public_members_url = "https://api.github.com/orgs/elpassion/public_members{/member}";
        elPassion.avatar_url = "https://avatars.githubusercontent.com/u/98255?v=3";
        elPassion.description = "App Development & Design House. We code in Ruby, JavaScript, Swift, Objective-C, Java, Groovy...";
        elPassion.name = "EL Passion";
        elPassion.company = null;
        elPassion.blog = "http://www.elpassion.com/";
        elPassion.location = "Warsaw, Poland";
        elPassion.email = "hello@elpassion.com";
        elPassion.public_repos = 37;
        elPassion.public_gists = 0;
        elPassion.followers = 0;
        elPassion.following = 0;
        elPassion.html_url = "https://github.com/elpassion";
        elPassion.created_at = "2009-06-23T18:10:20Z";
        elPassion.updated_at = "2015-08-08T10:31:55Z";
        elPassion.type = "Organization";
        return elPassion;
    }
}
