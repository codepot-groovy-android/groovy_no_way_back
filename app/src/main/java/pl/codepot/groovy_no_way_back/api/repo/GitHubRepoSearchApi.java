package pl.codepot.groovy_no_way_back.api.repo;

import pl.codepot.groovy_no_way_back.dto.GitHubRepo;
import pl.codepot.groovy_no_way_back.dto.GitHubSearchResults;
import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

public interface GitHubRepoSearchApi {

    @GET("/search/repositories")
    Observable<GitHubSearchResults<GitHubRepo>> get(@Query("q") String query);
}
