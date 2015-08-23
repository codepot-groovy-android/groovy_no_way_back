package pl.codepot.groovy_no_way_back.dto;

import java.util.Arrays;
import java.util.List;

public final class GitHubSearchResults<T> {

    public Integer totalCount;
    public Boolean incompleteResults;
    public List<T> items;

    public GitHubSearchResults(T... items) {
        this.totalCount = items.length;
        this.incompleteResults = false;
        this.items = Arrays.asList(items);
    }
}
