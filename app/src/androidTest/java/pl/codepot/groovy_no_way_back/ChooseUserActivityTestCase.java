package pl.codepot.groovy_no_way_back;

import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.test.ActivityInstrumentationTestCase2;

import pl.codepot.groovy_no_way_back.dagger.Injector;

import static android.support.test.espresso.Espresso.onView;

public final class ChooseUserActivityTestCase extends ActivityInstrumentationTestCase2<ChooseUserActivity> {

    public ChooseUserActivityTestCase() {
        super(ChooseUserActivity.class);
    }

    public void testShouldDisplaySearchResults() {
        Injector.setTestModules(new TestModules());
        getActivity();
        onView(ViewMatchers.withId(R.id.username_view)).check(ViewAssertions.matches(ViewMatchers.withText("OrdonTeam")));
    }
}
