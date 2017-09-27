package com.example.android.realestatepractice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView scoreTextView;
    Button tryAgainButton;
    int score;
    int questListSize;
    int percentage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        scoreTextView = (TextView) findViewById(R.id.score_text_view);
        tryAgainButton = (Button) findViewById(R.id.try_again_button);
        //get score
        Bundle bundle = getIntent().getExtras();
        score = bundle.getInt("score");
        questListSize = bundle.getInt("questListSize");
        percentage = (score/questListSize);
        scoreTextView.setText("Your score is " + score + " out of " + questListSize
        + ": " + percentage + "%");

        tryAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

}
