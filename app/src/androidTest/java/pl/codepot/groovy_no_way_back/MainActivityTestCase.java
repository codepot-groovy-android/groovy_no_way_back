package pl.codepot.groovy_no_way_back;

import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.Suppress;

import pl.codepot.groovy_no_way_back.dagger.Injector;
import pl.codepot.groovy_no_way_back.module.GitHubUserTestModule;

import static android.support.test.espresso.Espresso.onView;

public final class MainActivityTestCase extends ActivityInstrumentationTestCase2<MainActivity> {
    public MainActivityTestCase() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        Injector.setTestModules(new GitHubUserTestModule());
        getActivity();
    }

    @Deprecated
    @Suppress
    public void testShouldDisplayLogin() {
        onView(ViewMatchers.withId(R.id.scoreView)).check(ViewAssertions.matches(ViewMatchers.withText("OrdonTeam")));
    }
}
