package com.example.android.realestatepractice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import static com.example.android.realestatepractice.R.id.question;

public class PracticeTest extends AppCompatActivity {

    List<Question> quesList;
    TextView mQuestionTextView;
    Button buttonChoice1;
    Button buttonChoice2;
    Button buttonChoice3;
    Button buttonChoice4;
    Button nextButton;
    Question currentQuestion;
    int mQuestionId;
    int mIndex;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_test);

        DbHelper db = new DbHelper(this);
        quesList = db.getAllQuestions();
        currentQuestion = quesList.get(mQuestionId);


        //load the saved instance state if the app is closed or flipped to landscape mode
        if (savedInstanceState != null) {
            //load the score and index of question
            mIndex = savedInstanceState.getInt("IndexKey");
        } else {
            //user starting from scratch, so...
            mIndex = 0;
        }

        mQuestionTextView = (TextView) findViewById(question);
        buttonChoice1 = (Button) findViewById(R.id.answer1);
        buttonChoice2 = (Button) findViewById(R.id.answer2);
        buttonChoice3 = (Button) findViewById(R.id.answer3);
        buttonChoice4 = (Button) findViewById(R.id.answer4);
        nextButton = (Button) findViewById(R.id.next_button);

        setQuestionView();

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer();
            }
        });
    }

    private void checkAnswer() {
        //TODO: check answer
        RadioGroup grp = (RadioGroup) findViewById(R.id.radioGroup1);
        RadioButton answer = (RadioButton) findViewById(grp.getCheckedRadioButtonId());
        if (currentQuestion.getAnswer().equals(answer.getText().toString())) {
            Toast.makeText(getApplicationContext(), R.string.correct_toast, Toast.LENGTH_LONG).show();
            score++;
            Log.d("score", "Your score"+score);
        } else {
            Toast.makeText(getApplicationContext(), "Chosen answer " + answer.getText().toString() +
                            " Real answer " + currentQuestion.getAnswer(),
                    Toast.LENGTH_LONG).show();
            //TODO: make the question list stop if there are no more questions and let users
            // return to the home screen
        } if (mQuestionId < quesList.size()) {
            currentQuestion = quesList.get(mQuestionId);
            setQuestionView();
            Log.d("debug ", "mQuestionId: " + currentQuestion);
            Log.d("debug ", "questList.size: " + quesList.size());
        } else {
            Log.d("debug ", "mQuestionId: " + currentQuestion);
            Log.d("debug ", "questList.size: " + quesList.size());
            finish();
        }

    }

    //We need this method so we can load it when someone switches to landscape mode
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("IndexKey", mIndex);
    }

    private void setQuestionView() {
        mQuestionTextView.setText(currentQuestion.getQuestion());
        buttonChoice1.setText(currentQuestion.getOpta());
        buttonChoice2.setText(currentQuestion.getOptb());
        buttonChoice3.setText(currentQuestion.getOptc());
        buttonChoice4.setText(currentQuestion.getOptd());
        mQuestionId++;
    }

}
