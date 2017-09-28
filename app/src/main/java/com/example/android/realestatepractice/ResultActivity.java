package com.example.android.realestatepractice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class ResultActivity extends AppCompatActivity {

    TextView scoreTextView;
    TextView incorrectQuestionTextView;
    Button tryAgainButton;
    int score;
    int questListSize;
    int percentage;
    List<Question> quesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        scoreTextView = (TextView) findViewById(R.id.score_text_view);
        tryAgainButton = (Button) findViewById(R.id.try_again_button);
        incorrectQuestionTextView = (TextView) findViewById(R.id.incorrect_question_text_view);

        //get score
        Bundle bundle = getIntent().getExtras();
        score = bundle.getInt("score");
        questListSize = bundle.getInt("questListSize");
        percentage = (questListSize/score);
        scoreTextView.setText("Your score is " + score + " out of " + questListSize
        + ": " + percentage + "%");

        //access the database and get the questions
        DbHelper db = new DbHelper(this);
        quesList = db.getAllQuestions();
        //get the questions/answers that were answered incorrectly
        String answerList = getAnswers(quesList);
        incorrectQuestionTextView.setText("Questions answered incorrectly:\n\n" + answerList);


        tryAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    //get questions and answers for questions that were answered wrong
    public String getAnswers(List<Question> questions) {
        int question = 1;
        StringBuffer sb = new StringBuffer();

        for (Question q : questions){
            if(!q.isAnsweredCorrectly()) { // check here if the answer wasn't correct and append it
                sb.append("Q").append(question).append(") ").append(q.getQuestion()).append("? \n");
                sb.append("Answer: ").append(q.getAnswer()).append("\n\n");
                question ++;
            }
        }
        return sb.toString();

    }

}
