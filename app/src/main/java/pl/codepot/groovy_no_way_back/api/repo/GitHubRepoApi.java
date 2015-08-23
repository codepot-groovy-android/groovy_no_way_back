package pl.codepot.groovy_no_way_back.api.repo;

import pl.codepot.groovy_no_way_back.dto.GitHubRepo;
import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

public interface GitHubRepoApi {

    @GET("/repos/{username}/{reponame}")
    Observable<GitHubRepo> get(
            @Path("username") String username,
            @Path("reponame") String reponame
    );
}
