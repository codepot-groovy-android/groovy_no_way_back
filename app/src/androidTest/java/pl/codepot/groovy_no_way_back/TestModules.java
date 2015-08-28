package pl.codepot.groovy_no_way_back;

import pl.codepot.groovy_no_way_back.dagger.Injector;
import pl.codepot.groovy_no_way_back.module.BestScoreRepositoryTestModule;
import pl.codepot.groovy_no_way_back.module.GitHubOrganizationTestModule;
import pl.codepot.groovy_no_way_back.module.GitHubRepoTestModule;
import pl.codepot.groovy_no_way_back.module.GitHubUserTestModule;
import pl.codepot.groovy_no_way_back.module.RestAdapterNotAccessibleModule;

public final class TestModules implements Injector.TestModulesProvider {

    public Object gitHubUserModule = new GitHubUserTestModule();

    @Override
    public Object[] getTestModules() {
        return new Object[]{
                new RestAdapterNotAccessibleModule(),
                new BestScoreRepositoryTestModule(),
                new GitHubOrganizationTestModule(),
                new GitHubRepoTestModule(),
                gitHubUserModule
        };
    }
}
