package pl.codepot.groovy_no_way_back;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import javax.inject.Inject;

import pl.codepot.groovy_no_way_back.calculator.CalculateScoreService;
import pl.codepot.groovy_no_way_back.dagger.Injector;
import pl.codepot.groovy_no_way_back.repository.ScoreSavingService;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

public final class CalculateScoreActivity extends Activity {

    @Inject
    CalculateScoreService calculateScoreService;
    @Inject
    ScoreSavingService scoreSavingService;

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
                .subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer score) {
                        onScoreCalculated(score);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        onError(throwable);
                    }
                });
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
    }

    private void onTryAgain() {
        Intent intent = new Intent(this, ChooseUserActivity.class);
        startActivity(intent);
        finish();
    }

    private void onError(Throwable throwable) {

    }
}
