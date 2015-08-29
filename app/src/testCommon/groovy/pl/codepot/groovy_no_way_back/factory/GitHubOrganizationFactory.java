package pl.codepot.groovy_no_way_back.factory;

import pl.codepot.groovy_no_way_back.dto.GitHubOrganization;

public final class GitHubOrganizationFactory {

    public static GitHubOrganization newElPassion() {
        GitHubOrganization elPassion = new GitHubOrganization();
        elPassion.id = 98255L;
        elPassion.login = "elpassion";
        elPassion.name = "EL Passion";
        elPassion.publicRepos = 37;
        return elPassion;
    }

    public static GitHubOrganization newOrgWithPublicRepos(int publicRepos) {
        GitHubOrganization elPassion = new GitHubOrganization();
        elPassion.id = -1L;
        elPassion.login = "newOrgWithPublicRepos";
        elPassion.name = "New organization with public repos";
        elPassion.publicRepos = publicRepos;
        return elPassion;
    }
}
