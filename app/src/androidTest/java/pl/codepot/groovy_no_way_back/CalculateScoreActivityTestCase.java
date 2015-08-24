package pl.codepot.groovy_no_way_back;

import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.test.ActivityInstrumentationTestCase2;

import pl.codepot.groovy_no_way_back.dagger.Injector;

import static android.support.test.espresso.Espresso.onView;

public final class CalculateScoreActivityTestCase extends ActivityInstrumentationTestCase2<CalculateScoreActivity> {

    public CalculateScoreActivityTestCase() {
        super(CalculateScoreActivity.class);
    }

    public void testShouldDisplayCalculatedScore() {
        Injector.setTestModules(new TestModules());
        getActivity();
        onView(ViewMatchers.withId(R.id.score_view)).check(ViewAssertions.matches(ViewMatchers.withText("25")));
    }

    public void testShouldDisplayBestScore() {
        Injector.setTestModules(new TestModules());
        getActivity();
        onView(ViewMatchers.withId(R.id.best_score_view)).check(ViewAssertions.matches(ViewMatchers.withText("16")));
    }
}
