package pl.codepot.groovy_no_way_back.api.repo;

import java.util.List;

import pl.codepot.groovy_no_way_back.dto.GitHubRepo;
import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

public interface GitHubUserReposApi {

    @GET("/users/{username}/repos")
    Observable<List<GitHubRepo>> get(@Path("username") String username);
}
