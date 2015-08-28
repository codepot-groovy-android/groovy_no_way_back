package pl.codepot.groovy_no_way_back.dto;

import com.google.gson.annotations.SerializedName;

public final class GitHubRepo {
    public long id;
    public String name;
    public int stargazersCount;
    public int watchersCount;
    public String language;
    public int forksCount;
}
