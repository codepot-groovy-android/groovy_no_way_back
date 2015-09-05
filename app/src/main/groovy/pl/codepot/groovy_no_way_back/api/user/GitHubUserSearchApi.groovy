package pl.codepot.groovy_no_way_back.api.user;

import pl.codepot.groovy_no_way_back.dto.GitHubSearchResults;
import pl.codepot.groovy_no_way_back.dto.GitHubUser;
import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

public interface GitHubUserSearchApi {

    @GET("/search/users")
    Observable<GitHubSearchResults<GitHubUser>> get(@Query("q") String query);
}
