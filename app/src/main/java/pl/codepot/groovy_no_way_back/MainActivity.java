package pl.codepot.groovy_no_way_back;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import javax.inject.Inject;

import pl.codepot.groovy_no_way_back.adapter.GitHubAdapter;
import pl.codepot.groovy_no_way_back.api.user.GitHubUserApi;
import pl.codepot.groovy_no_way_back.dagger.Injector;
import pl.codepot.groovy_no_way_back.dto.GitHubUser;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

public class MainActivity extends AppCompatActivity {

    @Inject
    GitHubUserApi gitHubUserApi;
    private Subscription subscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Injector.inject(this);
        setContentView(R.layout.activity_main);
        RecyclerView list = (RecyclerView) findViewById(R.id.list);
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setAdapter(new GitHubAdapter());
    }

    @Override
    protected void onResume() {
        super.onResume();
        subscription = gitHubUserApi.get("ordonteam")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<GitHubUser>() {
                    @Override
                    public void call(GitHubUser gitHubUser) {
                        displayUser(gitHubUser);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        displayError(throwable);
                    }
                });
    }

    private void displayUser(GitHubUser gitHubUser) {
        TextView usernameView = (TextView) findViewById(R.id.usernameView);
        usernameView.setText(gitHubUser.login);
    }

    private void displayError(Throwable throwable) {
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }
}
