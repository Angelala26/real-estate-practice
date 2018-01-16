package com.example.android.realestatepractice;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView scoreTextView;
    Button nextButton;
    int score;
    int questListSize;
    double percentage;
    int roundedPercentage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        scoreTextView = (TextView) findViewById(R.id.score_text_view);
        nextButton = (Button) findViewById(R.id.next_button);

        //get score
        Bundle bundle = getIntent().getExtras();
        score = bundle.getInt("score");
        questListSize = bundle.getInt("questListSize");
        //TODO: Fix score percentage
        percentage = ((score / (double)questListSize) * 100);
        roundedPercentage = (int) percentage;

        if(roundedPercentage <= 30) {
            scoreTextView.setTextColor(Color.parseColor("#FF0000"));

        } else if (roundedPercentage > 30 || roundedPercentage <= 65) {
            scoreTextView.setTextColor(Color.parseColor("#E5E500"));

        } else if (roundedPercentage > 65) {
            scoreTextView.setTextColor(Color.parseColor("#008000"));

        }

        scoreTextView.setText("Your score: " + roundedPercentage + "%");

        //set next button to go to incorrect question activity
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResultActivity.this, IncorrectQuestion.class);
                startActivity(intent);
                finish();
            }
        });

    }
}