package pl.codepot.groovy_no_way_back;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import javax.inject.Inject;

import dagger.ObjectGraph;
import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

public class MainActivity extends AppCompatActivity {

    @Inject
    GitHubUserApi gitHubUserApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ObjectGraph.create(new GitHubUserModule()).inject(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        gitHubUserApi.get("ordonteam").observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<GitHubUser>() {
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
}
