package pl.codepot.groovy_no_way_back;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import javax.inject.Inject;

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
        setContentView(R.layout.activity_main);
        Injector.inject(this);
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
        ImageView avatarView = (ImageView) findViewById(R.id.avatarView);
        Glide.with(this).load(gitHubUser.avatar_url).into(avatarView);
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
