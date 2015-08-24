package pl.codepot.groovy_no_way_back;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import pl.codepot.groovy_no_way_back.dagger.Injector;

public class StartGameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Injector.inject(this);
        setContentView(R.layout.start_game_activity);
        findViewById(R.id.play).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startChooseUserActivity();
            }
        });
    }

    private void startChooseUserActivity() {
        Intent intent = new Intent(this, ChooseUserActivity.class);
        startActivity(intent);
    }
}
