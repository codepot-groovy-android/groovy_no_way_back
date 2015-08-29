package pl.codepot.groovy_no_way_back

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import pl.codepot.groovy_no_way_back.dagger.Injector
import pl.codepot.groovy_no_way_back.repository.ScoreSavingService

import javax.inject.Inject

final class StartGameActivity extends AppCompatActivity {

    @Inject
    protected ScoreSavingService scoreSavingService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Injector.inject(this, this);
        setContentView(R.layout.start_game_activity);
        findViewById(R.id.play).onClickListener = { View v ->
            startChooseUserActivity()
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        TextView bestScoreView = (TextView) findViewById(R.id.best_score_view);
        bestScoreView.setText(scoreSavingService.getBestScoreAsString());
    }

    private void startChooseUserActivity() {
        Intent intent = new Intent(this, ChooseUserActivity.class);
        startActivity(intent);
    }
}
