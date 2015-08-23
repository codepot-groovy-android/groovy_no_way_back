package pl.codepot.groovy_no_way_back;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint("https://api.github.com")
                .setConverter(new GsonConverter(new Gson())).setClient(new OkClient()).setLogLevel(RestAdapter.LogLevel.FULL).build();
        GitHubUserApi gitHubUserApi = restAdapter.create(GitHubUserApi.class);
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
