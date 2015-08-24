package pl.codepot.groovy_no_way_back;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import pl.codepot.groovy_no_way_back.dagger.Injector;

public class StartGameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Injector.inject(this);
        setContentView(R.layout.start_game_activity);
    }
}
