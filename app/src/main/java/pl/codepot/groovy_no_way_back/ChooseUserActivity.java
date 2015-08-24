package pl.codepot.groovy_no_way_back;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import pl.codepot.groovy_no_way_back.adapter.GitHubAdapter;
import pl.codepot.groovy_no_way_back.api.user.GitHubUserSearchApi;
import pl.codepot.groovy_no_way_back.dagger.Injector;
import pl.codepot.groovy_no_way_back.dto.GitHubSearchResults;
import pl.codepot.groovy_no_way_back.dto.GitHubUser;
import pl.codepot.groovy_no_way_back.event.UserChoosenEvent;
import pl.codepot.groovy_no_way_back.random.RandomQueryGenerator;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

public final class ChooseUserActivity extends Activity {

    @Inject
    GitHubUserSearchApi gitHubUserSearchApi;
    @Inject
    RandomQueryGenerator randomQueryGenerator;
    GitHubAdapter adapter = new GitHubAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Injector.inject(this, this);
        setContentView(R.layout.choose_user_activity);
        RecyclerView usersListView = (RecyclerView) findViewById(R.id.users_list_view);
        usersListView.setLayoutManager(new LinearLayoutManager(this));
        usersListView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        EventBus.getDefault().register(this);
        gitHubUserSearchApi.get(randomQueryGenerator.getRandomQuery())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<GitHubSearchResults<GitHubUser>>() {
                    @Override
                    public void call(GitHubSearchResults<GitHubUser> gitHubSearchResults) {
                        displaySearchResults(gitHubSearchResults);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        handleError(throwable);
                    }
                });
    }

    private void displaySearchResults(GitHubSearchResults<GitHubUser> gitHubSearchResults) {
        adapter.add(gitHubSearchResults.items);
    }

    private void handleError(Throwable throwable) {
        findViewById(R.id.error_message).setVisibility(View.VISIBLE);
    }

    @SuppressWarnings("unused")
    public void onEvent(UserChoosenEvent event){
        Intent intent = new Intent(this, CalculateScoreActivity.class);
        intent.putExtra("login", event.gitHubUser.login);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onPause() {
        super.onPause();
        EventBus.getDefault().unregister(this);
    }
}
