package pl.codepot.groovy_no_way_back

import android.test.ActivityInstrumentationTestCase2
import groovy.transform.CompileStatic
import pl.codepot.groovy_no_way_back.dagger.Injector
import pl.codepot.groovy_no_way_back.module.TestModules
import rx.android.view.ViewActions

import static android.support.test.espresso.Espresso.onView
import static android.support.test.espresso.action.ViewActions.click
import static android.support.test.espresso.assertion.ViewAssertions.matches
import static android.support.test.espresso.matcher.ViewMatchers.*

@CompileStatic
public final class StartGameActivityTestCase extends ActivityInstrumentationTestCase2<StartGameActivity> {

    public StartGameActivityTestCase() {
        super(StartGameActivity.class)
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp()
        Injector.setTestModules(new TestModules())
        getActivity()
    }

    public void testShouldStartChooseActivityAfterPlayClicked() {
        onView withId(R.id.play) perform click()
        onView withId(R.id.users_list_view) check matches(isDisplayed())
    }

    public void testShouldShowSavedBestScoreOnResume() {
        onView(withId(R.id.best_score_view)).check(matches(withText("16")));
    }
}
