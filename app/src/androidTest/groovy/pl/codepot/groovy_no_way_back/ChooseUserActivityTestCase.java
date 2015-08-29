package pl.codepot.groovy_no_way_back;

import android.test.ActivityInstrumentationTestCase2;

import pl.codepot.groovy_no_way_back.dagger.Injector;
import pl.codepot.groovy_no_way_back.module.TestModules;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.Visibility.GONE;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static pl.codepot.groovy_no_way_back.module.TestModules.testModulesWithFailingGitHubUser;

public final class ChooseUserActivityTestCase extends ActivityInstrumentationTestCase2<ChooseUserActivity> {

    public ChooseUserActivityTestCase() {
        super(ChooseUserActivity.class);
    }

    public void testShouldDisplaySearchResults() {
        Injector.setTestModules(new TestModules());
        getActivity();
        onView(withId(R.id.username_view)).check(matches(withText("OrdonTeam")));
    }

    public void testShouldNotShowErrorMessageOnSuccess() {
        Injector.setTestModules(new TestModules());
        getActivity();
        onView(withText(R.string.error_message)).check(matches(withEffectiveVisibility(GONE)));
    }

    public void testShouldDisplayErrors() {
        Injector.setTestModules(testModulesWithFailingGitHubUser());
        getActivity();
        onView(withText(R.string.error_message)).check(matches(isDisplayed()));
    }

    public void testShouldStartCalculateActivity() {
        Injector.setTestModules(new TestModules());
        getActivity();
        onView(withId(R.id.username_view)).perform(click());
        onView(withId(R.id.best_score_view)).check(matches(isDisplayed()));
    }
}
