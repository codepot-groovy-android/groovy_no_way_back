package pl.codepot.groovy_no_way_back;

import pl.codepot.groovy_no_way_back.module.FailingGitHubUserTestModule;

public final class TestModulesBuilder {

    public static TestModules failingGitHubUserTestModule() {
        TestModules testModules = new TestModules();
        testModules.gitHubUserModule = new FailingGitHubUserTestModule();
        return testModules;
    }
}
