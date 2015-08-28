package pl.codepot.groovy_no_way_back;

import android.test.ActivityInstrumentationTestCase2;

import pl.codepot.groovy_no_way_back.dagger.Injector;
import pl.codepot.groovy_no_way_back.module.TestModules;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public final class CalculateScoreActivityTestCase extends ActivityInstrumentationTestCase2<CalculateScoreActivity> {

    public CalculateScoreActivityTestCase() {
        super(CalculateScoreActivity.class);
    }

    public void testShouldDisplayCalculatedScore() {
        Injector.setTestModules(new TestModules());
        getActivity();
        onView(withId(R.id.score_view)).check(matches(withText("42")));
    }

    public void testShouldDisplayBestScore() {
        Injector.setTestModules(new TestModules());
        getActivity();
        onView(withId(R.id.best_score_view)).check(matches(withText("16")));
    }

    //TODO: Implement test for this
    public void testShouldUpdateBestScore() {
    }
}
