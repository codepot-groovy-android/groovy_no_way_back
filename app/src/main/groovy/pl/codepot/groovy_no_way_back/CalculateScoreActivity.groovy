package pl.codepot.groovy_no_way_back

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import groovy.transform.CompileStatic
import pl.codepot.groovy_no_way_back.calculator.CalculateScoreService
import pl.codepot.groovy_no_way_back.dagger.Injector
import pl.codepot.groovy_no_way_back.repository.ScoreSavingService
import rx.android.schedulers.AndroidSchedulers

import javax.inject.Inject

@CompileStatic
final class CalculateScoreActivity extends Activity {

    @Inject
    protected CalculateScoreService calculateScoreService;
    @Inject
    protected ScoreSavingService scoreSavingService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculate_score_activity);
        Injector.inject(this, this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        calculateScoreService.calculateScore(getIntent().getStringExtra("login"))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this.&onScoreCalculated, this.&onError)
    }

    private void onScoreCalculated(Integer score) {
        TextView scoreView = (TextView) findViewById(R.id.score_view);
        scoreView.setText(Integer.toString(score));
        TextView bestScoreView = (TextView) findViewById(R.id.best_score_view);
        bestScoreView.setText(scoreSavingService.getBestScoreAsString());
        findViewById(R.id.try_again).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onTryAgain();
            }
        });
        scoreSavingService.saveBestScore(score);
    }

    private void onTryAgain() {
        Intent intent = new Intent(this, ChooseUserActivity.class);
        startActivity(intent);
        finish();
    }

    private void onError(Throwable throwable) {
        Log.e("tag", "error", throwable);
        findViewById(R.id.content).setVisibility(View.GONE);
        findViewById(R.id.error_message).setVisibility(View.VISIBLE);
    }
}
