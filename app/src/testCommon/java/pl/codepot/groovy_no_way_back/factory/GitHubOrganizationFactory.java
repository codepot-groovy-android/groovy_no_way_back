package pl.codepot.groovy_no_way_back.factory;

import pl.codepot.groovy_no_way_back.dto.GitHubOrganization;

public final class GitHubOrganizationFactory {

    public static GitHubOrganization newElPassion() {
        GitHubOrganization elPassion = new GitHubOrganization();
        elPassion.login = "elpassion";
        elPassion.id = 98255L;
        elPassion.name = "EL Passion";
        elPassion.public_repos = 37;
        elPassion.followers = 0;
        return elPassion;
    }
}
