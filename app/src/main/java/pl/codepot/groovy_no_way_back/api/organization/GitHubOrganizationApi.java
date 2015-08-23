package pl.codepot.groovy_no_way_back.api.organization;

import pl.codepot.groovy_no_way_back.dto.GitHubOrganization;
import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

public interface GitHubOrganizationApi {

    @GET("/orgs/{name}")
    Observable<GitHubOrganization> get(@Path("name") String name);
}
