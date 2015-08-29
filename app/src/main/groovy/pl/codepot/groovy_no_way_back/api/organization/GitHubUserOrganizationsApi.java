package pl.codepot.groovy_no_way_back.api.organization;

import java.util.List;

import pl.codepot.groovy_no_way_back.dto.GitHubOrganization;
import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

public interface GitHubUserOrganizationsApi {

    @GET("/users/{username}/orgs")
    Observable<List<GitHubOrganization>> get(@Path("username") String username);
}
