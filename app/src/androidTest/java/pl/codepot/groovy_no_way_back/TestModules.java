package pl.codepot.groovy_no_way_back;

import pl.codepot.groovy_no_way_back.dagger.Injector;
import pl.codepot.groovy_no_way_back.module.BestScoreRepositoryTestModule;
import pl.codepot.groovy_no_way_back.module.GitHubOrganizationTestModule;
import pl.codepot.groovy_no_way_back.module.GitHubRepoTestModule;
import pl.codepot.groovy_no_way_back.module.GitHubUserTestModule;

public final class TestModules implements Injector.TestModulesProvider {

    @Override
    public Object[] getTestModules() {
        return new Object[]{
                new BestScoreRepositoryTestModule(),
                new GitHubOrganizationTestModule(),
                new GitHubRepoTestModule(),
                new GitHubUserTestModule()
        };
    }
}
