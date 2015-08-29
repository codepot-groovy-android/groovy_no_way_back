package pl.codepot.groovy_no_way_back.api.user;

import pl.codepot.groovy_no_way_back.dto.GitHubUser;
import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

public interface GitHubUserApi {

    @GET("/users/{username}")
    Observable<GitHubUser> get(@Path("username") String username);
}
