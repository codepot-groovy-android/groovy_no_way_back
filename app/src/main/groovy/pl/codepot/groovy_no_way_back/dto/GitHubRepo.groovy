package pl.codepot.groovy_no_way_back.dto;

import com.google.gson.annotations.SerializedName;

public final class GitHubRepo {
    long id;
    String name;
    int stargazersCount;
    int watchersCount;
    String language;
    int forksCount;
}
