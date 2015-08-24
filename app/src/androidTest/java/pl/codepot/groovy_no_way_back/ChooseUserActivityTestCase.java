package pl.codepot.groovy_no_way_back;

import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.test.ActivityInstrumentationTestCase2;

import pl.codepot.groovy_no_way_back.dagger.Injector;

import static android.support.test.espresso.Espresso.onView;
import static pl.codepot.groovy_no_way_back.TestModulesBuilder.failingGitHubUserTestModule;

public final class ChooseUserActivityTestCase extends ActivityInstrumentationTestCase2<ChooseUserActivity> {

    public ChooseUserActivityTestCase() {
        super(ChooseUserActivity.class);
    }

    public void testShouldDisplaySearchResults() {
        Injector.setTestModules(new TestModules());
        getActivity();
        onView(ViewMatchers.withId(R.id.username_view)).check(ViewAssertions.matches(ViewMatchers.withText("OrdonTeam")));
    }

    public void testShouldNotShowErrorMessageOnSuccess() {
        Injector.setTestModules(new TestModules());
        getActivity();
        onView(ViewMatchers.withText(R.string.error_message)).check(ViewAssertions.matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.GONE)));
    }

    public void testShouldDisplayErrors() {
        Injector.setTestModules(failingGitHubUserTestModule());
        getActivity();
        onView(ViewMatchers.withText(R.string.error_message)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }
}
