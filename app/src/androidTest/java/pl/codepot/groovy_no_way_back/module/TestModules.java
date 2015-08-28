package pl.codepot.groovy_no_way_back.module;

import pl.codepot.groovy_no_way_back.dagger.Injector;

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

    public static TestModules testModulesWithFailingGitHubUser() {
        TestModules testModules = new TestModules();
        testModules.gitHubUserModule = new FailingGitHubUserTestModule();
        return testModules;
    }
}
