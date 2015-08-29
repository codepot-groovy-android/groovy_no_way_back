package pl.codepot.groovy_no_way_back.dto

import groovy.transform.CompileStatic;

@CompileStatic
final class GitHubRepo {
    long id;
    String name;
    int stargazersCount;
    int watchersCount;
    String language;
    int forksCount;
}
