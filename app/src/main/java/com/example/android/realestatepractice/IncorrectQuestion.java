package com.example.android.realestatepractice;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class IncorrectQuestion extends AppCompatActivity {

    TextView incorrectQuestionTextView;
    Button tryAgainButton;
    List<Question> quesList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incorrect_question);

        tryAgainButton = (Button) findViewById(R.id.try_again_button);
        incorrectQuestionTextView = (TextView) findViewById(R.id.incorrect_question_text_view);

        //access the database and get the questions
        DbHelper db = new DbHelper(this);
        quesList = db.getAllQuestions();
        //get the questions/answers that were answered incorrectly
        String answerList = getAnswers(quesList);
        incorrectQuestionTextView.setTextColor(Color.parseColor("#000000"));
        incorrectQuestionTextView.setText("Questions answered incorrectly:\n\n" + answerList);


        tryAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IncorrectQuestion.this, MainActivity.class);
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
                sb.append("Q").append(question).append(") ").append(q.getQuestion()).append("? \n\n");
                sb.append("Answer: ").append(q.getAnswer()).append("\n\n");
                question ++;
            }
        }
        return sb.toString();

    }
}
