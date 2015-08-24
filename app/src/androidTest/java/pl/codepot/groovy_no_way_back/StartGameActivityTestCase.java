package pl.codepot.groovy_no_way_back;

import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.test.ActivityInstrumentationTestCase2;

import pl.codepot.groovy_no_way_back.dagger.Injector;

import static android.support.test.espresso.Espresso.onView;

public final class StartGameActivityTestCase extends ActivityInstrumentationTestCase2<StartGameActivity> {

    public StartGameActivityTestCase() {
        super(StartGameActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        Injector.setTestModules(new TestModules());
        getActivity();
    }

    public void testShouldStartChooseActivityAfterPlayClicked() {
        onView(ViewMatchers.withId(R.id.play)).perform(ViewActions.click());
        onView(ViewMatchers.withId(R.id.users_list_view)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

    public void testShouldShowSavedBestScoreOnResume() {
        onView(ViewMatchers.withId(R.id.best_score_view)).check(ViewAssertions.matches(ViewMatchers.withText("16")));
    }
}
